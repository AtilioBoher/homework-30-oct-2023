package com.solvd.homework30nov2023.dao.mybatis;

import com.solvd.homework30nov2023.dao.IDepartmentDao;
import com.solvd.homework30nov2023.model.Department;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

public class DepartmentDao implements IDepartmentDao {
    @Override
    public Optional<Department> getById(Long id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            IDepartmentDao departmentDao = sqlSession.getMapper(IDepartmentDao.class);
            return departmentDao.getById(id);
        }
    }

    @Override
    public Long insert(Department department) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            IDepartmentDao departmentDao = sqlSession.getMapper(IDepartmentDao.class);
            departmentDao.insert(department);
            return department.getId();
        }
    }

    @Override
    public void update(Department department, Long id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            IDepartmentDao departmentDao = sqlSession.getMapper(IDepartmentDao.class);
            departmentDao.update(department, id);
        }
    }

    @Override
    public void removeById(Long id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            IDepartmentDao departmentDao = sqlSession.getMapper(IDepartmentDao.class);
            departmentDao.removeById(id);
        }
    }

    @Override
    public List<Department> getAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            IDepartmentDao departmentDao = sqlSession.getMapper(IDepartmentDao.class);
            return departmentDao.getAll();
        }
    }
}
