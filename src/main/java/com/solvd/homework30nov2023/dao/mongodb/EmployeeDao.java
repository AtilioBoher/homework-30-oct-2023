package com.solvd.homework30nov2023.dao.mongodb;

import com.solvd.homework30nov2023.dao.IEmployeeDao;
import com.solvd.homework30nov2023.model.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeDao implements IEmployeeDao {

    @Override
    public Optional<Employee> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long insert(Employee employee) {
        return null;
    }

    @Override
    public void update(Employee employee, Long id) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public List<Employee> getAll() {
        return null;
    }
}
