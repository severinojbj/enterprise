package com.example.enterprise.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name="salaries")
public class Salaries {
    @Id
    @JoinColumn(name = "emp_num", referencedColumnName = "emp_num")
    @Column (name = "emp_num")
    private int empNum;
    @Column (name = "salary")
    private int salary;
    @Column (name = "from_date")
    private Date fromDate;
    @Column (name = "to_date")
    private Date toDate;
}
