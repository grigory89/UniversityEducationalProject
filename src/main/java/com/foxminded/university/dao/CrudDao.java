package com.foxminded.university.dao;

import java.util.List;

public interface CrudDao<T> {
    T create(T object);

    T findById(int id);

    List<T> findAll();

    void update(T object);

    void delete(int id);
}
