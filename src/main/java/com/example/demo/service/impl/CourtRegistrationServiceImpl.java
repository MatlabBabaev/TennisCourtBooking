package com.example.demo.service.impl;

import com.example.demo.dto.CourtDto;
import com.example.demo.dto.PlayerDto;
import com.example.demo.dto.RegistrationRequestDto;
import com.example.demo.dto.RegistrationResponseDto;
import com.example.demo.entity.CourtRegistration;
import com.example.demo.exception.CourtsFullException;
import com.example.demo.exception.OldDateException;
import com.example.demo.repository.CourtRegistrationRepository;
import com.example.demo.service.CourtRegistrationService;
import com.example.demo.service.NotificationService;
import com.example.demo.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourtRegistrationServiceImpl implements CourtRegistrationService {
    private final CourtRegistrationRepository courtRegistrationRepository;
    private final PlayerService playerService;
    private final NotificationService notificationService;

    @Override
    @Transactional
    public RegistrationResponseDto register(RegistrationRequestDto dto) {
        if (dto.getRegistrationDate().isBefore(LocalDate.now())) {
            throw new OldDateException();
        }

        var occupation = courtRegistrationRepository.findGroupByCourtByRegistrationDate(dto.getRegistrationDate())
                .stream().filter(c -> c.getPlayerCount() < c.getCourt().getPlayerLimit()).findFirst().orElseThrow(CourtsFullException::new);


        CourtRegistration courtRegistration = new CourtRegistration();
        courtRegistration.setCourt(occupation.getCourt());
        courtRegistration.setRegistrationDate(dto.getRegistrationDate());

        var player = playerService.save(dto.getPlayer());

        courtRegistration.setPlayer(player);
        var registration = courtRegistrationRepository.save(courtRegistration);

        if (occupation.getPlayerCount() == occupation.getCourt().getPlayerLimit() - 1) {
            notificationService.notifyPlayer(registration.getRegistrationDate(), registration.getCourt());
        }

        return RegistrationResponseDto.builder()
                .registrationDate(registration.getRegistrationDate())
                .court(CourtDto.builder().id(registration.getCourt().getId()).name(registration.getCourt().getName()).build())
                .player(PlayerDto.builder().firstName(player.getFirstName()).lastName(player.getLastName()).phoneNumber(player.getPhoneNumber()).build())
                .build();

    }

    @Override
    public List<CourtRegistration> getActiveRegistrations() {
        return courtRegistrationRepository.findAllByRegistrationDateIsGreaterThanEqual(LocalDate.now());
    }
}
