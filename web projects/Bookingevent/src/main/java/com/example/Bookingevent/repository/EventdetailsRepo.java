package com.example.Bookingevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Bookingevent.model.Eventdetails;

@Repository

public interface EventdetailsRepo extends JpaRepository<Eventdetails, Integer> {

}