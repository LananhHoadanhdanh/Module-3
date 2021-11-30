package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService<T> {
    ArrayList<T> findAll();
    void add(T t);
    int findIndexById(int id);
    T findById(int id);
    ArrayList<T> findByName(String name);
    ArrayList<T> findByPrice(double minPrice, double maxPrice);
    void update(int id, T t);
    void remove(int id);
}
