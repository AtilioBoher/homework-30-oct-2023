package com.solvd.homework30nov2023.dao;

import com.solvd.homework30nov2023.model.Department;

import java.util.List;

public interface IDepartmentDao extends IBaseDao<Department> {

    Department getById(int id);

    int insert(Department department);

    void update(Department department);

    void removeById(int id);

    List<Department> getAll();
}
