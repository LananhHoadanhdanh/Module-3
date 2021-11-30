package service;

import model.Student;

import java.util.List;

public interface StudentService<T> {
    List<T> findAll();
    int findIndexById(int id);
    T findById(int id);
    void update(int id, T t);
    void delete(int id);
}
