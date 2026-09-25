package com.yseop.web.service;

import java.util.List;

import com.yseop.web.table.LeffSem;

public interface ILeffSemService {

    List<LeffSem> findAll();

    LeffSem findById(Integer id);

    List<LeffSem> findByWordId(Integer wordId);

    void save(LeffSem leffSem);

    Long countLeffSem();

    LeffSem saveAndFlush(LeffSem leffSem);
}
