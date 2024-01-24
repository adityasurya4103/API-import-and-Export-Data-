package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.user;



public interface userRepository extends JpaRepository<user, String>{

}
