package com.example.enterprise.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.enterprise.entity.Departments;
import com.example.enterprise.service.DepartmentsService;

@Controller // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class DepartmentController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private DepartmentsService deptService;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String deptNum
      , @RequestParam String deptName) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Departments n = new Departments();

    n.setDeptNum(deptNum);
    n.setDeptName(deptName);
    deptService.insertDepartments(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Departments> getAllDepartments() {
    // This returns a JSON or XML with the users
    return deptService.findAll();
  }

  @GetMapping(path="/search/name")
  public @ResponseBody String getDepartmentByName(@RequestParam String deptName) {
    // This returns a JSON or XML with the users
    Departments resp = deptService.findByDeptName(deptName);
    return resp.toString();
  }

  @GetMapping(path="/search/num")
  public @ResponseBody String getDepartmentByNum(@RequestParam String deptNum) {
    // This returns a JSON or XML with the users
    return deptService.findByDeptNum(deptNum).toString();
  }

  @GetMapping(path="/search/name/{deptName}")
  public @ResponseBody String getDepartmentPathByName(@PathVariable String deptName) {
    // This returns a JSON or XML with the users
    Departments resp = deptService.findByDeptName(deptName);
    return resp.toString();
  }

  @GetMapping(path="/search/num/{deptNum}")
  public @ResponseBody String getDepartmentPathByNum(@PathVariable String deptNum) {
    // This returns a JSON or XML with the users
    return deptService.findByDeptNum(deptNum).toString();
  }

  @PutMapping (path="/update")
  public @ResponseBody String updateDepartment (@RequestParam String deptNum
      , @RequestParam (required=false) String deptName) {  
      return this.deptService.updateDepartments(deptNum, deptName);
  }
  
  @DeleteMapping (path="/delete")
  public @ResponseBody String deleteDepartment (@RequestParam String deptNum) {
    return this.deptService.deleteDepartment (deptNum);
  } 
}