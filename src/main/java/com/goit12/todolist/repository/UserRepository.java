package com.goit12.todolist.repository;

import com.goit12.todolist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
//    @Query("from Users u where lower(u.username) like lower(:username)")
//    User findByUsername(@Param("username") String username);
Optional<User> findByUsername(String username);
}

