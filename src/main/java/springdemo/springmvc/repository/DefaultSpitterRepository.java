package springdemo.springmvc.repository;

import org.springframework.stereotype.Component;
import springdemo.springmvc.Spitter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

//@Component
public class DefaultSpitterRepository implements SpitterRepository {

    private Map<String, Spitter> spitterMap = new HashMap<>();

    @Override
    public Spitter save(Spitter spitter) {
        spitterMap.put(spitter.getUserName(), spitter);
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        return spitterMap.get(username);
//        return null;
    }

    @Override
    public void addSpitter(Spitter spitter) {
        throw  new NotImplementedException();
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
