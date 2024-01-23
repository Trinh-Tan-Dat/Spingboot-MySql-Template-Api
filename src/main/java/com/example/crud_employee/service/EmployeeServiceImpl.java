package com.example.crud_employee.service;

import com.example.crud_employee.model.Employee;
import com.example.crud_employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee!=null){
            return employeeRepository.save(employee);
        }
        return  null;
    }

    //update employee
    @Override
    public Employee updateEmployee(long id, Employee employee) {
        if (id >= 1) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);
            if (optionalEmployee.isPresent()) {
                Employee employee1 = optionalEmployee.get();
                employee1.setName(employee.getName());
                employee1.setAddress(employee.getAddress());
                employeeRepository.save(employee1);
                return employee1;
            }
        }
        return null;
    }
    //delete employee
    @Override
    public boolean deleteEmployee(long id) {
        if (id >= 1) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);
            if (optionalEmployee.isPresent()) {
                employeeRepository.deleteById(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getOneEmployee(long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
