package com.kavindu.repository;

import com.kavindu.model.CricketPractisesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketPractisesRepository extends JpaRepository<CricketPractisesEntity,Integer> {
}
