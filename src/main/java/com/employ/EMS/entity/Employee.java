package com.employ.EMS.entity;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name")
    private String lastName;



    @Column(name = "Email" , nullable = false , unique = true)
    private String email;

    @Column(name = "first_name")
    private String firstName;


    public Employee(Long id, String firstName, String email, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
    }


    public Employee() {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
