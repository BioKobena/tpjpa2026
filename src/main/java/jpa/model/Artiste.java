package jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Artiste extends User {
    @Id
    @GeneratedValue
    private int id;
    private String nationalite;

    public Artiste() {}

    public Artiste(String nationalite) {
        this.nationalite = nationalite;
    }

    public int getId() {
        return this.id;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getNationalite() {
        return this.nationalite;
    }
}
