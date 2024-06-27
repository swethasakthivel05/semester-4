package com.example.sanzu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sanzu.model.Medicine;
import com.example.sanzu.repository.MedicineRepositry;

@Service
public class MedicineService {
    @Autowired
    private final MedicineRepositry medicineRepositry;

    public MedicineService(MedicineRepositry medicineRepositry) {
        this.medicineRepositry = medicineRepositry;
    }

    public Medicine createMedicine(Medicine medicine) {
        return medicineRepositry.save(medicine);
    }

    public List<Medicine> getAllMedicine() {
        return medicineRepositry.findAll();
    }

    public Medicine getMedicineId(int medicineId) {
        return medicineRepositry.findById(medicineId).orElse(null);
    }

}
