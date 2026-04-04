package jpa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Concert implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String lieu;
    private String date;
    private String genre_musicale;
    private String description;
    private int popularite;
    private int nombre_place;
    private int prixTicket;

    @OneToMany(mappedBy = "concert", cascade = CascadeType.PERSIST)
    private List<Artiste> artistes = new ArrayList<>();

    @OneToMany(mappedBy = "concert", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ticket> tickets = new ArrayList<>();

    public Concert() {
    }

    public Concert(String lieu, String date, String genre_musicale, String description, int popularite,
            int nombre_place) {
        this.lieu = lieu;
        this.date = date;
        this.genre_musicale = genre_musicale;
        this.description = description;
        this.popularite = popularite;
        this.nombre_place = nombre_place;
    }

    public int getId() {
        return this.id;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getLieu() {
        return this.lieu;
    }

    public List<Ticket> getTickets() {
        return this.tickets;
    }

    public List<Artiste> getArtists() {
        return this.artistes;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void setGenreMusicale(String genre_musicale) {
        this.genre_musicale = genre_musicale;
    }

    public String getGenreMusicale() {
        return this.genre_musicale;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setPopularite(int popularite) {
        this.popularite = popularite;
    }

    public int getPopularite() {
        return this.popularite;
    }

    public void setNombrePlace(int nombre_place) {
        this.nombre_place = nombre_place;
    }

    public int getNombrePlace() {
        return this.nombre_place;
    }

    public void setArtistes(List<Artiste> artistes) {
        this.artistes.clear();
        if (artistes != null) {
            this.artistes.addAll(artistes);
        }
    }

    public int getPrixTicket() {
        return this.prixTicket;
    }

    public void setPrixTicket(int prixTicket) {
        this.prixTicket = prixTicket;
    }

    public void addArtiste(Artiste artiste) {
        artistes.add(artiste);
        artiste.setConcert(this);
    }

    public void createTickets() {
        if (tickets.isEmpty() && nombre_place > 0 && prixTicket > 0) {
            for (int i = 1; i <= nombre_place; i++) {
                Ticket ticket = new Ticket();
                ticket.setNumero("T" + id + "-" + String.format("%04d", i));
                ticket.setPrix(prixTicket);
                ticket.setConcert(this);
                tickets.add(ticket);
            }
        }
    }

}
