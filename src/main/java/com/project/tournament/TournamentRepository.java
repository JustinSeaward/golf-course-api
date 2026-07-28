package com.project.tournament;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    List<Tournament> findTournamentByStartDate(LocalDate tournamentStartDate);
    Tournament findTournamentByLocation(String location);
    Tournament findTournamentById(Long id);
}
