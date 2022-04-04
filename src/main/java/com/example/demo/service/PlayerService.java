package com.example.demo.service;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.Player;

public interface PlayerService {
    Player save(PlayerDto player);
}
