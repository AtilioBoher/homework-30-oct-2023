package com.solvd.homework30nov2023.dao;

import java.util.List;

public interface IBaseDao<T> {

    T getById(int id);

    int insert(T t);

    void update(T t, Long id);

    void removeById(int id);

    List<T> getAll();
}
