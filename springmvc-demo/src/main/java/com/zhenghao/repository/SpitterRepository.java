package com.zhenghao.repository;

import com.zhenghao.domain.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
    void addSpitter(Spitter spitter);
    void addSpitterWithNamedParam(Spitter spitter);
    Spitter findOne(String username);
}
