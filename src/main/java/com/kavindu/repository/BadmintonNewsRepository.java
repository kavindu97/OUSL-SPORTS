package com.kavindu.repository;

import com.kavindu.model.BadmintonNewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadmintonNewsRepository extends JpaRepository<BadmintonNewsEntity,Integer> {

}
