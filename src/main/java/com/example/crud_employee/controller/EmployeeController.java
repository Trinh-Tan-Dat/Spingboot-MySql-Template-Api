package com.example.crud_employee.controller;


import com.example.crud_employee.model.Employee;
import com.example.crud_employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/")
    public String test(){
        return "timoday";
    }
    //API add employee
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return iEmployeeService.addEmployee(employee);
    }

    //update employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return iEmployeeService.updateEmployee(id, employee);
    }


    //delete employee
    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable("id") Long id){
        return iEmployeeService.deleteEmployee(id);
    }

    //get list
    @GetMapping("/list")
    public List<Employee> getAllEmployee(){
        return iEmployeeService.getAllEmployee();
    }


}
