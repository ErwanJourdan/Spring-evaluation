package com.ECnantes.springDemo.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "lastname", nullable = false)
    private String lastName;
    @Column(name = "firstname", nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String job;



    @Override
    public String toString() {
        return "Collaborator id : " + id + ", lastName : " + lastName + ", firstName : " + firstName + ", job='" + job +"}\n";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}
