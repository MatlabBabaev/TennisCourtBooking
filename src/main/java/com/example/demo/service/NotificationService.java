package com.example.demo.service;

import com.example.demo.entity.Court;

import java.time.LocalDate;

public interface NotificationService {
    void notifyPlayer(LocalDate registrationDate, Court court);
}
