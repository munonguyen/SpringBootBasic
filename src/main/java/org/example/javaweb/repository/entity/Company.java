package org.example.javaweb.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name ="company")
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="image")
    private String image;

    @Column(name="address")
    private String address;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;
}
