package com.solvd.homework30nov2023.dao;

import java.util.List;
import java.util.Optional;

public interface IBaseDao<T> {

    Optional<T> getById(Long id);

    Long insert(T t);

    void update(T t, Long id);

    void removeById(Long id);

    List<T> getAll();
}
