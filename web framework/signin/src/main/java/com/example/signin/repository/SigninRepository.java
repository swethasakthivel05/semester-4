package com.example.signin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.signin.model.Client;

@Repository
public interface SigninRepository extends JpaRepository<Client, Integer> {

}
