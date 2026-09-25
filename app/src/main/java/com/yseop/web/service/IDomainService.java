package com.yseop.web.service;

import java.util.List;

import com.yseop.web.table.Domain;

public interface IDomainService {

    Domain findDomainById(Integer id);

    List<Domain> findAll();

    void save(Domain domain);

    Long countDomain();

    Domain saveAndFlush(Domain domain);

}
