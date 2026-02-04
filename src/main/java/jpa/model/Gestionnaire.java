package jpa.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Gestionnaire extends User {

    @Id
    @GeneratedValue
    private int id;

    public Gestionnaire() {

    }

    public int getId() {
        return this.id;
    }
}
