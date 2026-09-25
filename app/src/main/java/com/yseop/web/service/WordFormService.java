package com.yseop.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yseop.web.repository.WordFormRepository;
import com.yseop.web.table.WordForm;

@Service("wordFromeService")
public class WordFormService implements IWordFormService {

    @Autowired
    private WordFormRepository wordFormRepository;

    @Override
    public List<WordForm> findAll() {
        List<WordForm> wordForms = wordFormRepository.findAll();
        return wordForms;
    }

    @Override
    public void save(WordForm wordForm) {
        wordFormRepository.save(wordForm);
    }

    @Override
    public Long countWordForm() {
        return wordFormRepository.count();
    }

    @Override
    public List<WordForm> findByWordId(Integer wordId) {
        List<WordForm> wordForms = new ArrayList<WordForm>();
        try {
            wordForms = wordFormRepository.findByWord(wordId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return wordForms;
    }

    @Override
    public WordForm findById(Integer id) {
        WordForm wordForm = new WordForm();
        try {
            wordForm = wordFormRepository.findWordFormById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return wordForm;
    }

    @Override
    public WordForm saveAndFlush(WordForm wordForm) {
        return wordFormRepository.saveAndFlush(wordForm);
    }

}
