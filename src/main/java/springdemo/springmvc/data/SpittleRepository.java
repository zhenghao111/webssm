package springdemo.springmvc.data;

import springdemo.springmvc.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(Long id);
}
