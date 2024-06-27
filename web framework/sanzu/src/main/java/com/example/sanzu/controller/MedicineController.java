package com.example.sanzu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.sanzu.model.Medicine;
import com.example.sanzu.service.MedicineService;

@RestController
@RequestMapping("/api")
public class MedicineController {
    @Autowired
    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/medicines")
    // insert the data
    public ResponseEntity<Medicine> createMedicine(@RequestBody Medicine medicine) {
        Medicine creatMedicine = medicineService.createMedicine(medicine);
        return new ResponseEntity<>(creatMedicine, HttpStatus.CREATED);
    }

    @GetMapping("/medicine")
    public ResponseEntity<List<Medicine>> getAllMedicine() {
        List<Medicine> medicines = medicineService.getAllMedicine();
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    @GetMapping("/medicine/{medicineId}")
    public ResponseEntity<Medicine> getById(@PathVariable int medicineId) {
        Medicine medicine = medicineService.getMedicineId(medicineId);
        if (medicine != null) {
            return new ResponseEntity<>(medicine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
