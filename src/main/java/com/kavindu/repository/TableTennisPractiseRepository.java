package com.kavindu.repository;

import com.kavindu.model.TableTennisPractiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableTennisPractiseRepository extends JpaRepository<TableTennisPractiseEntity,Integer> {
}
