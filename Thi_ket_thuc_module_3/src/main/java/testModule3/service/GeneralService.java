package testModule3.service;

import java.util.List;

public interface GeneralService <T>{
    T findById(int id);
    List<T> findAll();
    void add(T t);
    void delete(int id);
    void edit(T t);
    List<T> findByName(String key);
}
