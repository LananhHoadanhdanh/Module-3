package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService<Student> {
    List<Student> students;

    public StudentServiceImpl() {
        students = new ArrayList<>();
        students.add(new Student("Hoa", 7.5, 7, 10));
        Student.count = Student.count + 1;
        students.add(new Student("Lan", 6.5, 7.5, 9));
        Student.count = Student.count + 1;
        students.add(new Student("Huong", 8, 8, 8.1));
        Student.count = Student.count + 1;
        students.add(new Student("Anh", 7, 9, 6.5));
        Student.count = Student.count + 1;
        students.add(new Student("Long", 9.2, 9.5, 7.5));
        Student.count = Student.count + 1;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Student findById(int id) {
        return students.get(findIndexById(id));
    }

    @Override
    public void update(int id, Student student) {
        students.set(findIndexById(id), student);
    }

    @Override
    public void delete(int id) {
        students.remove(findIndexById(id));
    }
}
