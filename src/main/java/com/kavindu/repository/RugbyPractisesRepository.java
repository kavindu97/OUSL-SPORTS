package com.kavindu.repository;

import com.kavindu.model.RugbyPractisesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RugbyPractisesRepository extends JpaRepository<RugbyPractisesEntity,Integer> {
}
