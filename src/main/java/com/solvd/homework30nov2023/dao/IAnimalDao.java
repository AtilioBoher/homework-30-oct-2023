package com.solvd.homework30nov2023.dao;

import com.solvd.homework30nov2023.model.Animal;

import java.util.List;

public interface IAnimalDao extends IBaseDao<Animal> {

    Animal getById(int id);

    int insert(Animal animal);

    void update(Animal animal, Long id);

    void removeById(Long id);

    List<Animal> getAll();
}
