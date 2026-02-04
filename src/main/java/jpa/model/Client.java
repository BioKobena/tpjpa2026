package jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Client extends User {
    @Id
    @GeneratedValue
    private int id;

    public Client() {

    }

    public int getId() {
        return this.id;
    }

}
