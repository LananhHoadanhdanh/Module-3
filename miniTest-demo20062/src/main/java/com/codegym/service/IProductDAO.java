package com.codegym.service;

import com.codegym.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    void add(Product product) throws SQLException;

    Product findByID(int id);

    List<Product> findAll();

    List<Product> findByName(String key);

    List<Product> findAllOderByQuantity();

    boolean delete(int id) throws SQLException;

    boolean update(Product product) throws SQLException;
    public void delete1(int id);
}
