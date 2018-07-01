package springdemo.springmvc.data;

import org.springframework.stereotype.Component;
import springdemo.springmvc.Spitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
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
    }
}
