package com.kavindu.repository;


import com.kavindu.model.BoxingPractisesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxingPractisesRepository extends JpaRepository<BoxingPractisesEntity,Integer> {
}
