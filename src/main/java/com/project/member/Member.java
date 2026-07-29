package com.project.member;

import com.project.tournament.Tournament;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mailingAddress;
    private String email;
    private String phoneNumber;
    private LocalDate membershipStartDate;
    private String membershipType;

    @ManyToOne
    @JoinColumn(name = "tournament_member")
    private Tournament tournament;

    public Member() {
    }

    public Member(Long id, String name, String mailingAddress, String email, String phoneNumber, LocalDate membershipStartDate, String membershipType) {
        this.id = id;
        this.name = name;
        this.mailingAddress = mailingAddress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipStartDate = LocalDate.now();
        this.membershipType = membershipType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(LocalDate membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}

