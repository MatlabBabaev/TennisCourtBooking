package com.example.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RegistrationResponseDto {
    private PlayerDto player;
    private CourtDto court;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate registrationDate;
}
