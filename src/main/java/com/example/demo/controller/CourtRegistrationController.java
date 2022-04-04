package com.example.demo.controller;

import com.example.demo.entity.CourtRegistration;
import com.example.demo.service.CourtRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/court_registration")
@RequiredArgsConstructor
public class CourtRegistrationController {
    private final CourtRegistrationService courtRegistrationService;

    @GetMapping("")
    public List<CourtRegistration> getActiveRegistrations() {
        return courtRegistrationService.getActiveRegistrations();
    }
}
