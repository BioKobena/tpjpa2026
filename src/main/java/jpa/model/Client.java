package jpa.model;

import jakarta.persistence.Entity;

@Entity
public class Client extends User {

    private String compte_bancaire;
    public Client() {
    }

    public Client(String compte_bancaire) {
        this.compte_bancaire = compte_bancaire;
    }

    public void setCompteBancaire(String compte_bancaire) {
        this.compte_bancaire = compte_bancaire;
    }

    public String getCompteBancaire() {
        return this.compte_bancaire;
    }

}
