package com.example.enterprise.entity;

import java.io.Serializable;
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
@Table (name="dept_emp")
public class DeptEmp implements Serializable{
    @Id
    @JoinColumn(name = "emp_num", referencedColumnName = "emp_num")
    @Column (name = "emp_num")
    private int empNum;
    @Id
    @JoinColumn(name = "dept_num", referencedColumnName = "dept_num")
    @Column (name = "dept_num")
    private String deptNum;
    @Column (name = "from_date")
    private Date fromDate;
    @Column (name = "to_date")
    private Date toDate;
}

