package springdemo.springmvc.repository;

import springdemo.springmvc.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
    void addSpitter(Spitter spitter);
    void addSpitterWithNamedParam(Spitter spitter);
    Spitter findOne(String username);
}
