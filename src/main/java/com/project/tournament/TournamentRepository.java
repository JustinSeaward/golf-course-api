package com.project.tournament;

import com.project.member.Member;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface TournamentRepository extends CrudRepository<Tournament, Long> {
    List<Tournament> findTournamentByStartDate(LocalDate tournamentStartDate);
    Tournament findTournamentByLocation(String location);
}
