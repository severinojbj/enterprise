package com.example.enterprise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enterprise.entity.Departments;
import com.example.enterprise.repository.DepartmentRepository;


@Service
public class DepartmentsService {
    
    @Autowired
    private DepartmentRepository deptRepository;

    public List<Departments> findAll() {
        return this.deptRepository.findAll();
    }

    public Departments findByDeptName (String deptName) {
        return this.deptRepository.findDeptByName(deptName);
    }

    public Departments findByDeptNum (String deptNum) {
        return this.deptRepository.findDeptByNum(deptNum);
    }

    public void insertDepartments (Departments dept) {
        this.deptRepository.save(dept);
    } 

    public String updateDepartments (String deptNum, String deptName) {
        String message = "Department with number " + deptNum + " not exists.";
        Departments deptExists = this.findByDeptNum(deptNum);
        if (deptExists != null) {
            deptExists.setDeptNum(deptNum);
            deptExists.setDeptName(deptName);
            this.deptRepository.save(deptExists);
            message = "Department update success!";
        }
        return message;
    }

    public String deleteDepartment (String deptNum) {
        String message = "Department with number " + deptNum + " not exists.";
        Departments deptExists = this.findByDeptNum(deptNum);
        if (deptExists != null) {
            this.deptRepository.delete(deptExists);
            message = "Department delete success!";
        }
        return message;
    }
}
