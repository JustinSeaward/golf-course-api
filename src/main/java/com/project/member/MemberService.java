package com.project.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    public Member createMember(Member member){
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers(){
        return (List<Member>) memberRepository.findAll();
    }

    public List<Member> getMemberByName(String name){
        return memberRepository.findMemberByName(name);
    }

    public List<Member> getMemberByMembershipType(String membershipType){
        return memberRepository.findMemberByMembershipType(membershipType);
    }

    public Member getMemberByPhoneNumber(String phoneNumber) {
        return memberRepository.findMemberByPhoneNumber(phoneNumber);
    }

    public List<Member> getMemberByTournamentStartDate(LocalDate startDate){
        return memberRepository.findMemberByTournamentStartDate(startDate);
    }
}
