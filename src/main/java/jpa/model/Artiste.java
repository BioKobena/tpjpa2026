package jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Artiste extends User {

    private String nationalite;

    @ManyToOne
    @JoinColumn(name = "concert_id")
    @JsonIgnore
    private Concert concert;

    public Artiste() {
    }

    public Artiste(String nationalite) {
        this.nationalite = nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getNationalite() {
        return this.nationalite;
    }

    public Concert getConcert() {
        return this.concert;
    }

    public void setConcert(Concert c) {
        this.concert = c;
    }
}
