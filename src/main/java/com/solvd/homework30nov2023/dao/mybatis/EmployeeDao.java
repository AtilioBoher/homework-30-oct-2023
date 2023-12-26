package com.solvd.homework30nov2023.dao.mybatis;

import com.solvd.homework30nov2023.dao.IEmployeeDao;
import com.solvd.homework30nov2023.model.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

public class EmployeeDao implements IEmployeeDao {
    @Override
    public Optional<Employee> getById(Long id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            IEmployeeDao employeeDao = sqlSession.getMapper(IEmployeeDao.class);
            return employeeDao.getById(id);
        }
    }

    @Override
    public Long insert(Employee employee) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            IEmployeeDao employeeDao = sqlSession.getMapper(IEmployeeDao.class);
            employeeDao.insert(employee);
            return employee.getId();
        }
    }

    @Override
    public void update(Employee employee, Long id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            IEmployeeDao employeeDao = sqlSession.getMapper(IEmployeeDao.class);
            employeeDao.update(employee, id);
        }
    }

    @Override
    public void removeById(Long id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            IEmployeeDao employeeDao = sqlSession.getMapper(IEmployeeDao.class);
            employeeDao.removeById(id);
        }
    }

    @Override
    public List<Employee> getAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            IEmployeeDao employeeDao = sqlSession.getMapper(IEmployeeDao.class);
            return employeeDao.getAll();
        }
    }
}
