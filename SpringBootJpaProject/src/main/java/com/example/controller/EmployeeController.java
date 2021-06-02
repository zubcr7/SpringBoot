package com.example.controller;

 

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

import com.example.beans.Employee;
import com.example.exception.EmployeeException;
import com.example.services.IEmployeeService;

 

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private IEmployeeService iEmployeeService;
    
    @GetMapping("/displayAll")
    public ResponseEntity<List<Employee>> displayEmployees() {
        List<Employee> employeeList = iEmployeeService.displayEmployee();
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }
    
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee){
            Employee emp = iEmployeeService.addEmployee(employee);
            return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }
    
    @GetMapping("/searchEmployee/{id}")
    public ResponseEntity<Employee> searchEmployee(@PathVariable("id") int id) throws EmployeeException{
        Employee emp = iEmployeeService.searchEmployeeById(id);
        return new ResponseEntity<Employee>(emp,HttpStatus.OK);
    }
    
    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
            Employee emp = iEmployeeService.updateEmployee(employee);
            return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id) throws EmployeeException{
        iEmployeeService.deleteEmployeeById(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

 

}


