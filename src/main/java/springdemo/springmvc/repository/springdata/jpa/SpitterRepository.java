package springdemo.springmvc.repository.springdata.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import springdemo.springmvc.domain.Spitter;

//JpaConfig会扫描这个包，有继承Repository实现类的就会自动实现该接口
//TODO Java8中的多继承学一下
public interface SpitterRepository
        extends JpaRepository<Spitter, String>, SpitterSweeper {
}
