// package com.example.description.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.description.model.Description;

// @Repository
// public interface DescriptionRepository extends JpaRepository<Description, Integer> {

// }
package com.example.description.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.description.model.Description;

public interface DescriptionRepository extends JpaRepository<Description, Integer> {
    // No additional method declarations here
}
