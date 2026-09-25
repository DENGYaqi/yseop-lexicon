package com.yseop.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yseop.web.table.LeffSem;

@Repository
public interface LeffSemRepository extends JpaRepository<LeffSem, Integer> {

    LeffSem findLeffSemById(Integer id);

    List<LeffSem> findByWord(Integer wordId);

    @Override
    List<LeffSem> findAll();

    @SuppressWarnings("unchecked")
    @Override
    LeffSem save(LeffSem lfs);

}
