package com.example.demo.service;

import com.example.demo.dto.RegistrationRequestDto;
import com.example.demo.dto.RegistrationResponseDto;
import com.example.demo.entity.CourtRegistration;

import java.util.List;

public interface CourtRegistrationService {
    RegistrationResponseDto register(RegistrationRequestDto dto);

    List<CourtRegistration> getActiveRegistrations();
}
