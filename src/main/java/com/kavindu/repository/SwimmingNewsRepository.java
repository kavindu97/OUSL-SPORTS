package com.kavindu.repository;

import com.kavindu.model.SwimmingNewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwimmingNewsRepository extends JpaRepository<SwimmingNewsEntity,Integer> {
}
