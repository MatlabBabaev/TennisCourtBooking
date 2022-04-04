package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourtDto {
    private long id;
    private String name;
}
