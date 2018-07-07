package springdemo.springmvc.repository.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import springdemo.springmvc.domain.Spitter;

//JpaConfig会扫描这个包，有继承Repository实现类的就会自动实现该接口
public interface SpitterReporistory extends JpaRepository<Spitter, String> {
}
