package springdemo.springmvc.data;

import springdemo.springmvc.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
