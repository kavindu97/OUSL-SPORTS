package com.kavindu.repository;

import com.kavindu.model.SwimmingPractiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwimmingPractiseRepository extends JpaRepository<SwimmingPractiseEntity,Integer> {
}
