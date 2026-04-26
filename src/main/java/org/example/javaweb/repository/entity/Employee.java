package org.example.javaweb.repository.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="age")
    private Integer age;

    @Column(name="image")
    private String image;

    @Column(name="address")
    private String address;

    @ManyToOne
    Company company;


}
