package springdemo.springmvc.repository;

import springdemo.springmvc.domain.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(Long id);
}
