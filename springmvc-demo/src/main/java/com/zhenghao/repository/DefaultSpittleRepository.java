package com.zhenghao.repository;

import org.springframework.stereotype.Component;
import com.zhenghao.domain.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DefaultSpittleRepository implements SpittleRepository {


    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return createSpittleList(20);
    }

    @Override
    public Spittle findOne(Long id) {
        return new Spittle(1234L, "message", new Date());
//        return null;
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("spittle" + i, new Date(), Double.valueOf(i), Double.valueOf(i)));
        }
        return spittles;
    }
}
