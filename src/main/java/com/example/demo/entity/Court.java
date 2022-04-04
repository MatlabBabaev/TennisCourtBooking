package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Court {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int playerLimit;

    public Court(String name, int playerLimit) {
        this.name = name;
        this.playerLimit = playerLimit;
    }
}
