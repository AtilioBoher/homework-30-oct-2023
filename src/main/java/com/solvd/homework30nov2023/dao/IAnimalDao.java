package com.solvd.homework30nov2023.dao;

import com.solvd.homework30nov2023.model.Animal;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface IAnimalDao extends IBaseDao<Animal> {

    Optional<Animal> getById(Long id);

    Long insert(Animal animal);

    void update(@Param("animal") Animal animal, @Param("id") Long id);

    void removeById(Long id);

    List<Animal> getAll();
}
