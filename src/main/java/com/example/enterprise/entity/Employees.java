package com.example.enterprise.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name="employees")
public class Employees {
    @Id
    @Column (name = "emp_num")
    private int empNum;
    @Column (name = "birth_date")
    private Date birthDate;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    @Column (name = "gender")
    private char gender;
    @Column (name = "hire_date")
    private Date hireDate;
}