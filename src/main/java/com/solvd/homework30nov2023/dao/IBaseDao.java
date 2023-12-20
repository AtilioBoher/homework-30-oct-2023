package com.solvd.homework30nov2023.dao;

import java.util.List;

public interface IBaseDao<T> {

    T getById(int id);

    void insert(T t);

    void update(T t);

    void remove(T t);

    List<T> getAll();
}
