package com.solvd.homework30nov2023.dao;

import com.solvd.homework30nov2023.model.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface IDepartmentDao extends IBaseDao<Department> {

    Optional<Department> getById(Long id);

    Long insert(Department department);

    void update(@Param("department") Department department,@Param("id") Long id);

    void removeById(Long id);

    List<Department> getAll();
}
