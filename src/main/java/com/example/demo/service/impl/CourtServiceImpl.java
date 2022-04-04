package com.example.demo.service.impl;

import com.example.demo.entity.Court;
import com.example.demo.repository.CourtRepository;
import com.example.demo.service.CourtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourtServiceImpl implements CourtService {
    private final CourtRepository courtRepository;

    @Override
    public Court getFirstCourt() {
        return courtRepository.findAll().get(0);
    }

    @Override
    public List<Court> getAll() {
        return courtRepository.findAll();
    }
}
