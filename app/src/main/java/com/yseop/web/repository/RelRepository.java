package com.yseop.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yseop.web.table.Rel;
import com.yseop.web.table.RelPrimaryKey;

@Repository
public interface RelRepository extends JpaRepository<Rel, Integer> {

    Rel findByPrimaryKey(RelPrimaryKey relPrimaryKey);

    List<Rel> findBySource(Integer id);

    List<Rel> findByTarget(Integer id);

    List<Rel> findByName(String name);
}
