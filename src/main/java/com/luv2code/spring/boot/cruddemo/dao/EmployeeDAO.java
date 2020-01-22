package com.luv2code.spring.boot.cruddemo.dao;


import com.luv2code.spring.boot.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);

}
