package com.yseop.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yseop.web.repository.LeffSemRepository;
import com.yseop.web.table.LeffSem;

@Service("leffSemService")
public class LeffSemService implements ILeffSemService {

    @Autowired
    private LeffSemRepository leffSemRepository;

    @Override
    public List<LeffSem> findAll() {
        List<LeffSem> leffSems = leffSemRepository.findAll();
        return leffSems;
    }

    @Override
    public LeffSem findById(Integer id) {
        LeffSem leffSem = new LeffSem();
        try {
            leffSem = leffSemRepository.findLeffSemById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return leffSem;
    }

    @Override
    public List<LeffSem> findByWordId(Integer wordId) {
        List<LeffSem> leffSems = new ArrayList<LeffSem>();
        try {
            leffSems = leffSemRepository.findByWord(wordId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return leffSems;
    }

    @Override
    public void save(LeffSem leffSem) {
        leffSemRepository.save(leffSem);
    }

    @Override
    public Long countLeffSem() {
        return leffSemRepository.count();
    }

    @Override
    public LeffSem saveAndFlush(LeffSem leffSem) {
        return leffSemRepository.saveAndFlush(leffSem);
    }
}
