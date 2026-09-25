package com.yseop.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yseop.web.table.Domain;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Integer> {

    Domain findDomainById(Integer id);

    @Override
    List<Domain> findAll();

    @SuppressWarnings("unchecked")
    @Override
    Domain save(Domain domain);
}
