package com.example.Bookingevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Bookingevent.model.Event;

@Repository
public interface EventRepo extends JpaRepository<Event, Integer> {

}