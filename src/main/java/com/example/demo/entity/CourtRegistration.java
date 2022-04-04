package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class CourtRegistration {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate registrationDate;
    @ManyToOne
    private Court court;
    @ManyToOne
    private Player player;
}
