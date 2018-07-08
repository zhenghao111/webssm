package springdemo.springmvc.repository.springdata;

import springdemo.springmvc.domain.Spitter;
import springdemo.springmvc.repository.SpitterRepository;

public interface SpitterSweeper  {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
    void addSpitter(Spitter spitter);
    void addSpitterWithNamedParam(Spitter spitter);
    Spitter findOne(String username);
}
