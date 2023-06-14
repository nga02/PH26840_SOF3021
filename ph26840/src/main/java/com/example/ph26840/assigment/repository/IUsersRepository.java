package com.example.ph26840.assigment.repository;

import com.example.ph26840.assigment.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRepository extends JpaRepository<Users,Integer> {
    Users  findByTen(String username);
}
