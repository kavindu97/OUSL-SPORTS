package com.kavindu.repository;

import com.kavindu.model.BadmintonPractiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadmintonPractiseRepository extends JpaRepository<BadmintonPractiseEntity,Integer> {
}
