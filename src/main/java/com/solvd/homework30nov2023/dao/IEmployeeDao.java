package com.solvd.homework30nov2023.dao;

import com.solvd.homework30nov2023.model.Employee;

import java.util.List;

public interface IEmployeeDao extends IBaseDao<Employee>{
    Employee getById(int id);

    void insert(Employee t);

    void update(Employee t);

    void remove(Employee t);

    List<Employee> getAll();
}
