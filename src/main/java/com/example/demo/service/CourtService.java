package com.example.demo.service;

import com.example.demo.entity.Court;

import java.util.List;

public interface CourtService {
    Court getFirstCourt();

    List<Court> getAll();
}
