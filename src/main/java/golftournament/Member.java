package golftournament;

import javax.persistence.*;
import java.util.Date;

//Show annotations
@Entity
@Table
public class Member {
    //Declare fields
    @Id // Mark primary key field
    @GeneratedValue // Auto generate ID
    private int id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String email;

    // Constructors (Default for JPA, and with parameters)
    public Member() {}

    public Member(int id, String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    // Getters/Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}