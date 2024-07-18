package com.itsutra.employeemgmt.enitity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//
//    @OneToMany(mappedBy = "role")
//    private List<Employee> employees;

}
