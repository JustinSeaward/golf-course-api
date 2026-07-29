package com.project.tournament;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private long entryFee;
    private long winnerAmount;
    private List<String> members;

    public Tournament(){

    }

    public Tournament(Long id, LocalDate startDate, LocalDate endDate, String location, long entryFee, long winnerAmount, List<String> members) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.winnerAmount = winnerAmount;
        this.members = members;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(long entryFee) {
        this.entryFee = entryFee;
    }

    public long getWinnerAmount() {
        return winnerAmount;
    }

    public void setWinnerAmount(long winnerAmount) {
        this.winnerAmount = winnerAmount;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
