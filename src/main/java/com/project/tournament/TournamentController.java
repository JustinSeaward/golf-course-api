package com.project.tournament;

import com.project.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tournament")
@CrossOrigin
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @PostMapping
    public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament){
        Tournament newTournament = tournamentService.createTournament(tournament);

        if (newTournament == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newTournament);
    }

    @GetMapping("/tournamentlist")
    public ResponseEntity<List<Tournament>> getAllTournaments() {
        List<Tournament> tournaments = tournamentService.getAllTournaments();

        if(tournaments.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(tournaments);
    }

    @GetMapping("/search/tournament/startdate/{startDate}")
    public ResponseEntity<List<Tournament>> getTournamentByStartDate(@PathVariable LocalDate startDate) {
        List<Tournament> tournaments = tournamentService.getTournamentByStartDate(startDate);

        if (tournaments.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(tournaments);
    }

    @GetMapping("/search/location/{location}")
    public ResponseEntity<Tournament> getTournamentByLocation(@PathVariable String location) {
        Tournament tournaments = tournamentService.getTournamentByLocation(location);

        if (tournaments == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(tournaments);
    }
}
