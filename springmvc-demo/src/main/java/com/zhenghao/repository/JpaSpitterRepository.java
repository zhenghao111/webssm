package com.zhenghao.repository;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import com.zhenghao.domain.Spitter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

//因为没有使用Template类来处理异常，PersistenceExceptionTranslationPostProcessor将这个bean的异常转化为Spring统一的数据访问异常
//@Repository
//持久化的方法是在事物上下文中执行
@Transactional
public class JpaSpitterRepository implements SpitterRepository{

    //方式一：注入实体管理器工厂，用来创建实体管理器
    @PersistenceUnit
    private EntityManagerFactory emf;

    //方式二：注入实体管理器的代理，真正的实体管理是和事物相关联，不存在这样的实体管理器就会创建一个新的，是线程安全的
    //TODO 报错
//    @PersistenceContext
//    private EntityManager em;


    @Override
    @Transactional
//    @Secured("USER")
    @PreAuthorize("#spitter.password.length()>=6")
    public void addSpitter(Spitter spitter) {
        //方式一：创建实体管理器,EntityManager是线程不安全的，每次都创建一个新实例
//        emf.createEntityManager().persist(spitter);
        //方式二
//        em.persist(spitter);
    }

    @Override
    public void addSpitterWithNamedParam(Spitter spitter) {
        throw new NotImplementedException();
    }

    @Override
    public Spitter findOne(String username) {
//        return emf.createEntityManager().find(Spitter.class, username);
//        return em.find(Spitter.class, username);
        throw new NotImplementedException();
    }

    @Override
    public Spitter save(Spitter spitter) {
        throw new NotImplementedException();
    }

    @Override
    public Spitter findByUsername(String username) {
        throw new NotImplementedException();
    }
}
