package com.yseop.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yseop.web.repository.DomainRepository;
import com.yseop.web.table.Domain;

@Service("domainService")
public class DomainService implements IDomainService {

    @Autowired
    private DomainRepository domainRepository;

    @Override
    public Domain findDomainById(Integer id) {
        return domainRepository.findDomainById(id);
    }

    @Override
    public List<Domain> findAll() {
        List<Domain> domains = domainRepository.findAll();
        return domains;
    }

    @Override
    public void save(Domain domain) {
        domainRepository.save(domain);
    }

    @Override
    public Long countDomain() {
        return domainRepository.count();
    }

    @Override
    public Domain saveAndFlush(Domain domain) {
        return domainRepository.saveAndFlush(domain);
    }

}
