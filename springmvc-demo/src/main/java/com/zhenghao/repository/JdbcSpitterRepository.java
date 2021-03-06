package com.zhenghao.repository;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import com.zhenghao.domain.Spitter;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//方式一：组件扫描@Repository和自动装配@Inject
//方式二：在JavaConfig中显示声明为Bean
//@Bean
//public SpitterRepository spitterRepository(JdbcTemplate jdbcTemplate) {
//        return new JdbcSpitterRepository(jdbcTemplate);//会注入JdbcTemplate对象
//}

@Repository //包含了@Component，组件扫描和自动装配方案@Inject
public class JdbcSpitterRepository implements SpitterRepository {

    //JdbcTempalte类是JdbcOperations接口的实现类
    private JdbcOperations jdbcOperations;

    @Inject //与@Autowired作用一样
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    private final String INSERT_SPITTER = "insert into spitter(firstname, lastname, username, password) values(?, ?, ?, ?)";

    @Override
    public Spitter save(Spitter spitter) {
        throw new NotImplementedException();
    }

    @Override
    public Spitter findByUsername(String username) {
        throw new NotImplementedException();
    }

    @Override
    public void addSpitter(Spitter spitter) {
        jdbcOperations.update(INSERT_SPITTER,
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getUserName(),
                spitter.getPassword()
        );
    }

    //使用命名参数的JdbcTemplate
    private final String INSERT_SPITTER2 = "insert into spitter(firstname, lastname, username, password) " +
            "values(:firstname, :lastname, :username, :password)";
    @Override
    public void addSpitterWithNamedParam(Spitter spitter) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("firstname", spitter.getFirstName());
        paramMap.put("lastname", spitter.getLastName());
        paramMap.put("username", spitter.getUserName());
        paramMap.put("password", spitter.getPassword());
    }


    private final String SELECT_SPITTER_BY_USERNAME = "select * from spitter where username=?";
    @Override
    public Spitter findOne(String username) {
       return jdbcOperations.queryForObject(
               SELECT_SPITTER_BY_USERNAME,
//               new RowMapper<Spitter>() {
//
//                   @Override
//                   public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
//                       return new Spitter(
//                               resultSet.getString("firstname"),
//                               resultSet.getString("lastname"),
//                               resultSet.getString("username"),
//                               resultSet.getString("password"));
//                   }
//               },
               //或者如果只有一个方法，可以用Lambda
//               (resultSet, rowNum) -> {
//                   return new Spitter(
//                           resultSet.getString("firstname"),
//                           resultSet.getString("lastname"),
//                           resultSet.getString("username"),
//                           resultSet.getString("password"));
//               },
               //或者用方法引用
               this::mapSpitter,
               username
       );
    }

    private Spitter mapSpitter(ResultSet rs, int row) throws SQLException {
        return new Spitter(
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("username"),
                rs.getString("password")
        );
    }
}
