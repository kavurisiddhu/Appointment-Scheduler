package com.matrix.codechallenge.springboot.web.repository;

import com.matrix.codechallenge.springboot.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
