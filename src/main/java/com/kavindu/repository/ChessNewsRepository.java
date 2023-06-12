package com.kavindu.repository;

import com.kavindu.model.ChessNewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChessNewsRepository extends JpaRepository<ChessNewsEntity,Integer> {
}
