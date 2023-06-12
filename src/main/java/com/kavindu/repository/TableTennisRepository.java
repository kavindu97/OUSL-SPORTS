package com.kavindu.repository;

import com.kavindu.model.TableTennisNewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableTennisRepository extends JpaRepository<TableTennisNewsEntity,Integer> {
}
