package com.yseop.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yseop.web.table.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {

    List<Word> findByLemma(String lemma);

    @Override
    List<Word> findAll();

    Word findWordById(Integer id);

    @SuppressWarnings("unchecked")
    @Override
    Word save(Word word);
}
