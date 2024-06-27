package com.example.Bookingevent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Eventdetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int EventId;
    private String dateOfTheEvent;
    private String location;
    private String costPackages;
    private String startTime;
    private String endTime;
    private String eventTypeDescription;
}