package com.project.member;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {
    List<Member> findMemberByName(String name);
    List<Member> findMemberByMembershipType(String membershipType);
    Member findMemberByPhoneNumber(String phoneNumber);
    List<Member> findMemberByTournamentStartDate(LocalDate tournamentStartDate);
}
