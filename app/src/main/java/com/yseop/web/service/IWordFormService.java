package com.yseop.web.service;

import java.util.List;

import com.yseop.web.table.WordForm;

public interface IWordFormService {

    List<WordForm> findAll();

    void save(WordForm wordForm);

    WordForm findById(Integer id);

    Long countWordForm();

    List<WordForm> findByWordId(Integer wordId);

    WordForm saveAndFlush(WordForm wordForm);
}
