package com.yseop.web.service;

import java.util.List;

import com.yseop.web.table.Rel;
import com.yseop.web.table.RelPrimaryKey;

public interface IRelService {

    List<Rel> findAll();

    Rel findByPK(RelPrimaryKey relPrimaryKey);

    List<Rel> findBySourceId(Integer id);

    List<Rel> findByTargetId(Integer id);

    List<Rel> findByName(String name);

    Long countRel();

    Rel saveAndFlush(Rel rel);

}
