package com.kavindu.repository;

import com.kavindu.model.RugbyNewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RugbyNewsRepository extends JpaRepository<RugbyNewsEntity,Integer> {
}
