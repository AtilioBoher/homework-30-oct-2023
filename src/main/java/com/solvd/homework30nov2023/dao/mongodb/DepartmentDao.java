package com.solvd.homework30nov2023.dao.mongodb;

import com.solvd.homework30nov2023.dao.IDepartmentDao;
import com.solvd.homework30nov2023.model.Department;

import java.util.List;
import java.util.Optional;

public class DepartmentDao implements IDepartmentDao {

    @Override
    public Optional<Department> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long insert(Department department) {
        return null;
    }

    @Override
    public void update(Department department, Long id) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public List<Department> getAll() {
        return null;
    }
}
