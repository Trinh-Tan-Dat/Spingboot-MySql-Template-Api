package com.example.crud_employee.service;

import com.example.crud_employee.model.Employee;

import java.util.List;

public interface IEmployeeService {
    //add new employee
    public Employee addEmployee(Employee employee);


    //update employee
    public Employee updateEmployee(long id, Employee employee);

    //delete employee
    public boolean deleteEmployee(long id );


    //get list employee
    public List<Employee> getAllEmployee();

    //get 1 employee
    public Employee getOneEmployee(long id);
}
