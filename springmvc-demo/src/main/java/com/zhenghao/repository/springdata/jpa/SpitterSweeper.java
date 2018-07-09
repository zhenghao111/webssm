package com.zhenghao.repository.springdata.jpa;

import com.zhenghao.domain.Spitter;

public interface SpitterSweeper  {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
    void addSpitter(Spitter spitter);
    void addSpitterWithNamedParam(Spitter spitter);
    Spitter findOne(String username);
}
