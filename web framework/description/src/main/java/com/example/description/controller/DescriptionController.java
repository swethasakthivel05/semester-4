// package com.example.description.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.description.model.Description;
// import com.example.description.repository.DescriptionRepository;

// @RestController
// @RequestMapping("/api")
// public class DescriptionController {
//     @Autowired
//     private final DescriptionRepository descriptionRepository;

//     public DescriptionController(DescriptionRepository descriptionRepository) {
//         this.descriptionRepository = descriptionRepository;
//     }

//     @PostMapping("/description")
//     // insert the data
//     public ResponseEntity<Description> createDescription(@RequestBody Description description) {
//         Description createDescription = descriptionRepository.createDescription(description);
//         return new ResponseEntity<>(createDescription, HttpStatus.CREATED);
//     }

//     @GetMapping("/description")
//     public ResponseEntity<List<Description>> getAllDescriptions() {
//         List<Description> description = descriptionRepository.getAllDescriptions();
//         return new ResponseEntity<>(description, HttpStatus.OK);
//     }

//     @GetMapping("/description/{signinId}")
//     public ResponseEntity<Description> getById(@PathVariable int signinId) {
//         Description description = descriptionRepository.getDescriptionId(signinId);
//         if (description != null) {
//             return new ResponseEntity<>(description, HttpStatus.OK);
//         } else {
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//         }
//     }

// }

package com.example.description.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.description.model.Description;
import com.example.description.service.DescriptionService;

@RestController
@RequestMapping("/api")
public class DescriptionController {
    private final DescriptionService descriptionService;

    public DescriptionController(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }

    @PostMapping("/description")
    public ResponseEntity<Description> createDescription(@RequestBody Description description) {
        Description createdDescription = descriptionService.createDescription(description);
        return new ResponseEntity<>(createdDescription, HttpStatus.CREATED);
    }

    @GetMapping("/description")
    public ResponseEntity<List<Description>> getAllDescriptions() {
        List<Description> descriptions = descriptionService.getAllDescriptions();
        return new ResponseEntity<>(descriptions, HttpStatus.OK);
    }

    @GetMapping("/description/{signinId}")
    public ResponseEntity<Description> getById(@PathVariable int signinId) {
        Description description = descriptionService.getDescriptionById(signinId);
        if (description != null) {
            return new ResponseEntity<>(description, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/description/{id}")
    public ResponseEntity<Description> update(@PathVariable int id, @RequestBody Description description) {
        return new ResponseEntity<>(descriptionService.update(id, description), HttpStatus.OK);
    }

    @DeleteMapping("/description/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        descriptionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
