package com.yseop.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yseop.web.table.Sense;
import com.yseop.web.table.Word;

@Repository
public interface SenseRepository extends JpaRepository<Sense, Integer> {

    Sense findSenseById(Integer id);

    List<Word> findSenseByWord(Integer id);

    List<Sense> findByConcept(Integer id);

    @Override
    List<Sense> findAll();

    @SuppressWarnings("unchecked")
    @Override
    Sense save(Sense sense);
}
