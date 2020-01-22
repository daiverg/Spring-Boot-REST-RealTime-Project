package com.luv2code.spring.boot.cruddemo.dao;


import com.luv2code.spring.boot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class EmployeeDAOhibernateImpl implements EmployeeDAO {

    private EntityManager entityManager;
    private Session currentSession;
    private Employee employee;


    @Autowired
    public EmployeeDAOhibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
//    @Transactional
    public List<Employee> findAll() {
//        Session currentSession = entityManager.unwrap(Session.class);
        currentSession = entityManager.unwrap(Session.class);

        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {
        currentSession = entityManager.unwrap(Session.class);
        employee = currentSession.get(Employee.class,id);

        return employee;
    }

    @Override
    public void save(Employee employee) {
        currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);

    }

    @Override
    public void deleteById(int id) {
        currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }


}
