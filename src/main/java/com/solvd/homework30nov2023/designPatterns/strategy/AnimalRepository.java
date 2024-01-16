package com.solvd.homework30nov2023.designPatterns.strategy;

import com.solvd.homework30nov2023.dao.IAnimalDao;
import com.solvd.homework30nov2023.model.Animal;

import java.util.List;
import java.util.Optional;

public class AnimalRepository {
    private IAnimalDao repository;

    public AnimalRepository() {
        this.repository = new com.solvd.homework30nov2023.dao.jdbc.AnimalDao(); // Use JDBC by default
    }

    public void useJDBC() {
        repository = new com.solvd.homework30nov2023.dao.jdbc.AnimalDao();
    }

    public void useMyBatis() {
        repository = new com.solvd.homework30nov2023.dao.mybatis.AnimalDao();
    }

    public Optional<Animal> getById(Long id) {
        return repository.getById(id);
    };

    public Long insert(Animal animal) {
        return repository.insert(animal);
    };

    public void update(Animal animal, Long id) {
        repository.update(animal, id);
    };

    public void removeById(Long id) {
        repository.removeById(id);
    };

    public List<Animal> getAll() {
        return repository.getAll();
    };
}
