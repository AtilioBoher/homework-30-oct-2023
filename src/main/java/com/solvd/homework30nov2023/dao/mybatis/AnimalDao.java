package com.solvd.homework30nov2023.dao.mybatis;

import com.solvd.homework30nov2023.dao.IAnimalDao;
import com.solvd.homework30nov2023.dao.IEmployeeDao;
import com.solvd.homework30nov2023.model.Animal;
import com.solvd.homework30nov2023.model.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

public class AnimalDao implements IAnimalDao {
    @Override
    public Optional<Animal> getById(Long id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            IAnimalDao animalDao = sqlSession.getMapper(IAnimalDao.class);
            return animalDao.getById(id);
        }
    }

    @Override
    public Long insert(Animal animal) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            IAnimalDao animalDao = sqlSession.getMapper(IAnimalDao.class);
            animalDao.insert(animal);
            return animal.getId();
        }
    }

    @Override
    public void update(Animal animal, Long id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            IAnimalDao animalDao = sqlSession.getMapper(IAnimalDao.class);
            animalDao.update(animal, id);
        }
    }

    @Override
    public void removeById(Long id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            IAnimalDao animalDao = sqlSession.getMapper(IAnimalDao.class);
            animalDao.removeById(id);
        }
    }

    @Override
    public List<Animal> getAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            IAnimalDao animalDao = sqlSession.getMapper(IAnimalDao.class);
            return animalDao.getAll();
        }
    }
}
