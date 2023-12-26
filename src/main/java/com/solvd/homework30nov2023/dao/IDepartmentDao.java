package com.solvd.homework30nov2023.dao;

import com.solvd.homework30nov2023.model.Department;

import java.util.List;
import java.util.Optional;

public interface IDepartmentDao extends IBaseDao<Department> {

    Optional<Department> getById(Long id);

    Long insert(Department department);

    void update(Department department, Long id);

    void removeById(Long id);

    List<Department> getAll();
}
