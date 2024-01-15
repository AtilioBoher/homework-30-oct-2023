package com.solvd.homework30nov2023.dao.mongodb;

import com.solvd.homework30nov2023.dao.IAnimalDao;
import com.solvd.homework30nov2023.model.Animal;

import java.util.List;
import java.util.Optional;

public class AnimalDao implements IAnimalDao {

    @Override
    public Optional<Animal> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long insert(Animal animal) {
        return null;
    }

    @Override
    public void update(Animal animal, Long id) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public List<Animal> getAll() {
        return null;
    }
}
