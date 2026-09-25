package com.yseop.web.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yseop.web.repository.RelRepository;
import com.yseop.web.table.Rel;
import com.yseop.web.table.RelPrimaryKey;

@Service("relService")
public class RelService implements IRelService {

    @Autowired
    private RelRepository relRepository;

    @Override
    public List<Rel> findAll() {
        List<Rel> rels = relRepository.findAll();
        return rels;
    }

    @Override
    public Rel findByPK(RelPrimaryKey relPrimaryKey) {
        Rel rel = new Rel();
        try {
            rel = relRepository.findByPrimaryKey(relPrimaryKey);

        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return rel;
    }

    @Override
    public List<Rel> findBySourceId(Integer id) {
        List<Rel> rels = new ArrayList<Rel>();
        try {
            rels = relRepository.findBySource(id);
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return rels;
    }

    @Override
    public List<Rel> findByTargetId(Integer id) {
        List<Rel> rels = relRepository.findByTarget(id);
        return rels;
    }

    @Override
    public List<Rel> findByName(String name) {
        List<Rel> rels = relRepository.findByName(name);
        return rels;
    }

    @Override
    public Long countRel() {
        return relRepository.count();
    }

    @Override
    public Rel saveAndFlush(Rel rel) {
        return relRepository.saveAndFlush(rel);
    }

}
