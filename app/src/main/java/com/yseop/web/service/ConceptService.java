package com.yseop.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yseop.web.repository.ConceptRepository;
import com.yseop.web.table.Concept;

@Service("conceptService")
public class ConceptService implements IConceptService {

    @Autowired
    private ConceptRepository conceptRepository;

    @Override
    public Concept findConceptById(Integer id) {
        return conceptRepository.findConceptById(id);
    }

    @Override
    public List<Concept> findAll() {
        List<Concept> concepts = conceptRepository.findAll();
        return concepts;
    }

    @Override
    public void save(Concept concept) {
        conceptRepository.save(concept);
    }

    @Override
    public Long countConcept() {
        return conceptRepository.count();
    }

    @Override
    public Concept saveAndFlush(Concept concept) {
        return conceptRepository.saveAndFlush(concept);
    }

}
