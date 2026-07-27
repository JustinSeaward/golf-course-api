package com.project.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findMemberByName(String name);
    List<Member> findMemberByMembershipType(String membershipType);
    Member findMemberByPhoneNumber(String phoneNumber);
    List<Member> findMemberByTournamentStartDate(LocalDate startDate);
}
