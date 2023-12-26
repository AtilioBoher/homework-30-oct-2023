package com.solvd.homework30nov2023.dao;

import com.solvd.homework30nov2023.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface IEmployeeDao extends IBaseDao<Employee> {
    Optional<Employee> getById(Long id);

    Long insert(Employee employee);

    void update(@Param("employee") Employee employee,@Param("id") Long id);

    void removeById(Long id);

    List<Employee> getAll();
}
