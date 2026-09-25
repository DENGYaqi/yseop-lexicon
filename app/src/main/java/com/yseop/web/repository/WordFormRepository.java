package com.yseop.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yseop.web.table.WordForm;

@Repository
public interface WordFormRepository extends JpaRepository<WordForm, Integer> {

    @Override
    List<WordForm> findAll();

    @SuppressWarnings("unchecked")
    @Override
    WordForm save(WordForm wf);

    List<WordForm> findByWord(Integer id);

    WordForm findWordFormById(Integer id);
}
