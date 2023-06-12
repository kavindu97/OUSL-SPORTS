package com.kavindu.repository;

import com.kavindu.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    @Query(value = "SELECT email,age FROM user_entity",nativeQuery = true)
   List<Map<String,Object>> neededcolumns();
//@Query(value = "SELECT * FROM user_entity WHERE email LIKE  CONCAT('%', :email, '%')",nativeQuery = true)
//    List<Object> search(@Param("email") String email);

    List<Object> findByEmailContainingIgnoreCase(String email);
  UserEntity findByEmail(String email);
    Optional<UserEntity> findOneByEmailAndPassword(String email, String password);
}
