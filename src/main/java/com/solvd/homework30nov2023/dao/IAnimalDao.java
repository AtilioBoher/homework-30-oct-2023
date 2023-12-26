package com.solvd.homework30nov2023.dao;

import com.solvd.homework30nov2023.model.Animal;

import java.util.List;
import java.util.Optional;

public interface IAnimalDao extends IBaseDao<Animal> {

    Optional<Animal> getById(Long id);

    Long insert(Animal animal);

    void update(Animal animal, Long id);

    void removeById(Long id);

    List<Animal> getAll();
}
