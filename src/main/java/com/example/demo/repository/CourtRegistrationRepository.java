package com.example.demo.repository;

import com.example.demo.entity.Court;
import com.example.demo.entity.CourtOccupation;
import com.example.demo.entity.CourtRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CourtRegistrationRepository extends JpaRepository<CourtRegistration, Long> {
    @Query(value = "select new com.example.demo.entity.CourtOccupation(c, count(cr.id)) from Court c left join CourtRegistration cr on c.id = cr.court.id and cr.registrationDate = :registrationDate group by c")
    List<CourtOccupation> findGroupByCourtByRegistrationDate(LocalDate registrationDate);

    List<CourtRegistration> findAllByRegistrationDateAndCourt(LocalDate registrationDate, Court court);

    List<CourtRegistration> findAllByRegistrationDateIsGreaterThanEqual(LocalDate registrationDate);
}
