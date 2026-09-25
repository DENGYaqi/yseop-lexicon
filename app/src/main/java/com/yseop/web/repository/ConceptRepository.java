package com.yseop.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yseop.web.table.Concept;

@Repository
public interface ConceptRepository extends JpaRepository<Concept, Integer> {

    @Override
    List<Concept> findAll();

    Concept findConceptById(Integer id);

    @SuppressWarnings("unchecked")
    @Override
    Concept save(Concept concept);
}
