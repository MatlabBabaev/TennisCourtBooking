package com.example.demo.service.impl;

import com.example.demo.entity.Court;
import com.example.demo.repository.CourtRegistrationRepository;
import com.example.demo.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final CourtRegistrationRepository courtRegistrationRepository;

    @Override
    public void notifyPlayer(LocalDate registrationDate, Court court) {
        courtRegistrationRepository.findAllByRegistrationDateAndCourt(registrationDate, court).forEach(cr -> {
            log.info("SENDING NOTIFICATION TO PLAYER {}", cr.getPlayer());
        });
    }
}
