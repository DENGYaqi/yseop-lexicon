package com.yseop.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yseop.web.repository.SenseRepository;
import com.yseop.web.table.Sense;
import com.yseop.web.table.Word;

@Service("senseService")
public class SenseService implements ISenseService {

    @Autowired
    private SenseRepository senseRepository;

    @Override
    public Sense findById(Integer id) {
        Sense sense = new Sense();
        try {
            sense = senseRepository.findSenseById(id);
        } catch (Exception e) {
            return null;
        }
        return sense;
    }

    @Override
    public List<Sense> findAllSenses() {
        List<Sense> senses = senseRepository.findAll();
        return senses;
    }

    @Override
    public Sense save(Sense sense) {
        return senseRepository.save(sense);
    }

    @Override
    public List<Word> findSenseByWord(Integer id) {
        return senseRepository.findSenseByWord(id);
    }

    @Override
    public List<Sense> findSenseByConcept(Integer concept) {
        return senseRepository.findByConcept(concept);
    }

    @Override
    public Long countSense() {
        return senseRepository.count();
    }

    @Override
    public Sense saveAndFlush(Sense newSense) {
        return senseRepository.saveAndFlush(newSense);
    }

    @Override
    public Sense merge(Sense sense) {
        return senseRepository.save(sense);
    }

    @Override
    public Sense getOne(Integer id) {
        return senseRepository.getOne(id);
    }

    @Override
    public Sense getSenseById(long id) {
        return senseRepository.getOne((int) id);
    }
}
