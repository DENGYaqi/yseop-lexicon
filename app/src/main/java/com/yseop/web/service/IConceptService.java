package com.yseop.web.service;

import java.util.List;

import com.yseop.web.table.Concept;

public interface IConceptService {

    Concept findConceptById(Integer id);

    List<Concept> findAll();

    void save(Concept concept);

    Long countConcept();

    Concept saveAndFlush(Concept concept);
}
