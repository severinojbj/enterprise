package com.example.enterprise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.enterprise.entity.Departments;

public interface DepartmentRepository extends JpaRepository <Departments, Integer> {
    
    @Query (value="SELECT * FROM departments WHERE departments.dept_num = :deptNum", nativeQuery = true)
    Departments findDeptByNum (@Param("deptNum") String deptNum);
    @Query (value="SELECT * FROM departments WHERE departments.dept_name = :deptName", nativeQuery = true)
    Departments findDeptByName (@Param("deptName") String deptName);
}