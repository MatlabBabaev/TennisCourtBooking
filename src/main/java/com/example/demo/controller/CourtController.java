package com.example.demo.controller;

import com.example.demo.entity.Court;
import com.example.demo.service.CourtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/court")
@RequiredArgsConstructor
public class CourtController {
    private final CourtService courtService;

    @GetMapping("")
    public List<Court> getAll() {
        return courtService.getAll();
    }
}
