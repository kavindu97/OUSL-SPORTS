package com.kavindu.repository;

import com.kavindu.model.CricketNewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketRepository extends JpaRepository<CricketNewsEntity,Integer> {
}
