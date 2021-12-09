package luyen_tap.service;

import java.util.List;

public interface GeneralService <T>{
    T findById(int id);
    void add(T t);
    void edit(T t);
    void delete(int id);
    List<T> findAll();
    List<T> findByName();
}
