package com.zhenghao.repository;

import com.zhenghao.domain.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(Long id);
}
