package springdemo.springmvc.repository.springdata;

import org.springframework.stereotype.Repository;
import springdemo.springmvc.domain.Spitter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

//注意SpitterRepository不是springdata.SpitterRepository
//混合自定义

public class SpitterRepositoryImpl implements SpitterSweeper {

//    @PersistenceContext
//    private EntityManager em;

    @PersistenceUnit
    private EntityManagerFactory emf;

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
        emf.createEntityManager().persist(spitter);
    }

    @Override
    public void addSpitterWithNamedParam(Spitter spitter) {
        throw new NotImplementedException();
    }

    @Override
    public Spitter findOne(String username) {
        throw new NotImplementedException();
    }
}
