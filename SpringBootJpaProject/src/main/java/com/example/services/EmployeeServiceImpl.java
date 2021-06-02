package com.example.services;

 

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.example.beans.Employee;
import com.example.dao.IEmployeeDAO;
import com.example.exception.EmployeeException;

 

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    
    @Autowired
    private IEmployeeDAO iEmployeeDAO;

 

    @Override
    public List<Employee> displayEmployee() {
        return iEmployeeDAO.findAll();
    }

 

    @Override
    public Employee addEmployee(Employee employee){
        return iEmployeeDAO.save(employee);
    }

 

    @Override
    public Employee searchEmployeeById(int id) throws EmployeeException{
        if(iEmployeeDAO.findById(id).isPresent())
            return iEmployeeDAO.findById(id).get();
        else
            throw new EmployeeException("employee does not exist");
        
    }

 

    @Override
    public Employee updateEmployee(Employee employee){
        return iEmployeeDAO.saveAndFlush(employee);
    }

 

    @Override
    public void  deleteEmployeeById(int id) throws EmployeeException{
        if(iEmployeeDAO.findById(id).isPresent())
              iEmployeeDAO.deleteById(id);
        else
            throw new EmployeeException("employee already deleted");
    }
    

}
