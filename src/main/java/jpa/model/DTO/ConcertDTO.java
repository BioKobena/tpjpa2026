package jpa.model.DTO;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ConcertDTO {

    @NotNull(message = "Lieu obligatoire")
    @Size(min = 2, max = 100, message = "Lieu 2-100 caractères")
    private String lieu;

    @NotNull(message = "Date obligatoire")
    @Size(min = 8, max = 10, message = "Date au format jj/mm/aaaa")
    private String date;

    @Size(max = 50, message = "Genre max 50 caractères")
    private String genreMusicale;

    @Size(max = 500, message = "Description max 500 caractères")
    private String description;

    @Min(value = 0, message = "Popularité ≥ 0")
    @Max(value = 100, message = "Popularité ≤ 100")
    private int popularite;

    @Min(value = 1, message = "Au moins 1 place")
    @Max(value = 10000, message = "Max 10 000 places")
    private int nombrePlace;

    private int prixTicket;
    private List<Long> artisteIds = new ArrayList<>();

    public String getLieu() {
        return lieu;
    }

    public String getDate() {
        return date;
    }

    public String getGenreMusicale() {
        return genreMusicale;
    }

    public String getDescription() {
        return description;
    }

    public int getPopularite() {
        return popularite;
    }

    public int getNombrePlace() {
        return nombrePlace;
    }

    public int getPrixTicket() {
        return this.prixTicket;
    }

    public void setPrixTicket(int prixTicket) {
        this.prixTicket = prixTicket;
    }

    public List<Long> getArtisteIds() {
        return this.artisteIds;
    }

    public void setArtisteIds(List<Long> artisteIds) {
        this.artisteIds = artisteIds == null ? new ArrayList<>() : artisteIds;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu != null ? lieu.trim() : null;
    }

    public void setDate(String date) {
        this.date = date != null ? date.trim() : null;
    }

    public void setGenreMusicale(String genre) {
        this.genreMusicale = genre != null ? genre.trim() : null;
    }

    public void setDescription(String desc) {
        this.description = desc != null ? desc.trim() : null;
    }

    public void setPopularite(int popularite) {
        this.popularite = Math.max(0, Math.min(100, popularite));
    }

    public void setNombrePlace(int places) {
        this.nombrePlace = Math.max(1, places);
    }

}
