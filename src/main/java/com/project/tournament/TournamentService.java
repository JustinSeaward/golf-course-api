package com.project.tournament;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public Tournament createTournament(Tournament tournament){
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> getAllTournaments(){
        return (List<Tournament>) tournamentRepository.findAll();
    }

    public Tournament getTournamentByLocation(String location) {
        return tournamentRepository.findTournamentByLocation(location);
    }

    public List<Tournament> getTournamentByStartDate(LocalDate startDate){
        return tournamentRepository.findTournamentByStartDate(startDate);
    }
}
