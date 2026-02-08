package com.example.festival.repository.interfaces;

import java.util.List;

public interface CrudRepository<T> {
    void create(T entity) throws Exception;
    T findById(int id) throws Exception;
    List<T> findAll() throws Exception;
    void update(T entity) throws Exception;
    void delete(int id) throws Exception;
}