package se.lexicon.jpa_workshop.entity;


import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class AppUser {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int Id;
    @Column (nullable = false , length = 255)
    private String firstName;
    @Column (nullable = false, length = 255)
    private String lastName;
    @Column (nullable = false, unique = true)
    private String email;




    public AppUser() {
    }




    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Id == appUser.Id && Objects.equals(firstName, appUser.firstName) && Objects.equals(lastName, appUser.lastName) && Objects.equals(email, appUser.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, lastName, email);
    }
}
