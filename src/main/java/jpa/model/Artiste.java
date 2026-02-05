package jpa.model;

import jakarta.persistence.Entity;

@Entity
public class Artiste extends User {
    private String nationalite;

    public Artiste() {}

    public Artiste(String nationalite) {
        this.nationalite = nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getNationalite() {
        return this.nationalite;
    }
}
