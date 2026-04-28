package jpa.model.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ArtisteDTO {
    @NotNull(message = "Nom obligatoire")
    @Size(min = 2, max = 50, message = "Nom entre 2-50 caractères")
    private String nom;

    @Size(max = 50, message = "Prénom max 50 caractères")
    private String prenom;

    @NotNull(message = "Nationalité obligatoire")
    @Size(min = 2, max = 30, message = "Nationalité 2-30 caractères")
    private String nationalite;

    @NotBlank(message = "Genre obligatoire")
    @Size(max = 20, message = "Genre max 20 caractères")
    private String genre;

    @Size(max = 120, message = "Email max 120 caractères")
    private String email;

    @Min(value = 16, message = "Âge minimum 16 ans")
    @Max(value = 100, message = "Âge maximum 100 ans")
    private int age;

    public String getNom() {
        return nom != null ? nom.trim().toUpperCase() : null;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public String getGenre() {
        return genre;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setNom(String nom) {
        if (nom != null && nom.trim().length() < 2)
            throw new IllegalArgumentException("Nom trop court");
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        if (age < 16 || age > 100)
            throw new IllegalArgumentException("Âge invalide");
        this.age = age;
    }
}
