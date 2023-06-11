package com.example.enterprise.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Table (name="dept_manager")
@Entity
@IdClass (DeptManager.class)
public class DeptManager implements Serializable{
    @Id
    @JoinColumn(name = "dept_num", referencedColumnName = "dept_num")
    @Column (name = "dept_num")
    private String deptNum;
    @Id
    @JoinColumn(name = "emp_num", referencedColumnName = "emp_num")
    @Column (name = "emp_num")
    private int empNum;
    @Column (name = "from_date")
    private Date fromDate;
    @Column (name = "to_date")
    private Date toDate;
}

