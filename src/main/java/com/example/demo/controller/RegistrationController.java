package com.example.demo.controller;

import com.example.demo.dto.RegistrationRequestDto;
import com.example.demo.dto.RegistrationResponseDto;
import com.example.demo.service.CourtRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final CourtRegistrationService courtRegistrationService;

    @PostMapping("")
    public RegistrationResponseDto register(@RequestBody @Valid RegistrationRequestDto dto) {
        return courtRegistrationService.register(dto);
    }
}
