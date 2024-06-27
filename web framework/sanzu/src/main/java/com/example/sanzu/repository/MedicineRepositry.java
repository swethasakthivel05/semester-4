package com.example.sanzu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sanzu.model.Medicine;

@Repository
public interface MedicineRepositry extends JpaRepository<Medicine, Integer> {

}
