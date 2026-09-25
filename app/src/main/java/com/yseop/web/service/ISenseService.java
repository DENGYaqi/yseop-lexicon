package com.yseop.web.service;

import java.util.List;

import com.yseop.web.table.Sense;
import com.yseop.web.table.Word;

public interface ISenseService {

    Sense findById(Integer id);

    List<Sense> findAllSenses();

    Sense save(Sense sense);

    List<Word> findSenseByWord(Integer id);

    List<Sense> findSenseByConcept(Integer concept);

    Long countSense();

    Sense saveAndFlush(Sense newSense);

    Sense merge(Sense sense);

    Sense getOne(Integer id);

    Sense getSenseById(long id);

}
