package com.solvd.homework30nov2023.dao;

import com.solvd.homework30nov2023.model.Employee;

import java.util.List;

public interface IEmployeeDao extends IBaseDao<Employee> {
    Employee getById(int id);

    int insert(Employee employee);

    void update(Employee employee);

    void removeById(int id);

    List<Employee> getAll();
}
