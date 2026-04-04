package jpa.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String numero;
    private int prix;

    @ManyToOne
    @JoinColumn(name = "concert_id")
    @JsonBackReference
    private Concert concert;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Ticket() {
    }

    public Ticket(int prix, Concert concert) {
        this.prix = prix;
        this.concert = concert;
    }

    public Concert getConcert() {
        return this.concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return this.client;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return this.numero;
    }

    public int getId() {
        return this.id;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getPrix() {
        return this.prix;
    }
}
