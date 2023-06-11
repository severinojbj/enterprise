package com.example.enterprise.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="departments")
public class Departments {
    @Id
    @Column (name="dept_num")
    private String deptNum;
    @Column (name="dept_name")
    private String deptName;

    @Override
    public String toString (){
        return "Dept number: " + this.deptNum + " | Dept name: " + this.deptName;
    }
}
