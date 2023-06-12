package com.kavindu.repository;

import com.kavindu.model.BoxingNewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxingNewsRepository extends JpaRepository<BoxingNewsEntity,Integer> {
}
