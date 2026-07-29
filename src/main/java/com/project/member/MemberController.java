package com.project.member;

import com.project.tournament.Tournament;
import com.project.tournament.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/member")
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private TournamentService tournamentService;

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member newMember = memberService.createMember(member);

        if (newMember == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newMember);
    }

    @GetMapping("/memberlist")
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();

        if (members.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(members);
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity<List<Member>> getMemberByName(@PathVariable String name) {
        List<Member> members = memberService.getMemberByName(name);

        if (members.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(members);
    }

    @GetMapping("/search/type/{membershipType}")
    public ResponseEntity<List<Member>> getMemberByMembershipType(@PathVariable String membershipType) {
        List<Member> members = memberService.getMemberByMembershipType(membershipType);

        if (members.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(members);
    }

    @GetMapping("/search/phone/{phoneNumber}")
    public ResponseEntity<Member> getMemberByPhoneNumber(@PathVariable String phoneNumber) {
        Member member = memberService.getMemberByPhoneNumber(phoneNumber);

        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    @GetMapping("/search/tournament/startdate/{startDate}")
    public ResponseEntity<List<Member>> getMemberByTournamentStartDate(@PathVariable LocalDate startDate) {
        List<Member> members = memberService.getMemberByTournamentStartDate(startDate);

        if (members.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(members);
    }

    @PostMapping("{memberId}/tournament/{tournamentId}")
        public ResponseEntity<Member> registerToTournament(@PathVariable Long tournamentId, @PathVariable Long memberId){
            Tournament tournament = tournamentService.getTournamentById(tournamentId);
            Member member = memberService.getMemberById(memberId);

            if(member == null || tournament == null){
                return ResponseEntity.notFound().build();
            }

            Member registerMember = memberService.registerMemberToTournament(member, tournament);

        return ResponseEntity.status(HttpStatus.OK).body(registerMember);
    }


}
