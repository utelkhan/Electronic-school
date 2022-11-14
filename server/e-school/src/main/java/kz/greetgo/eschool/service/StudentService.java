package kz.greetgo.eschool.service;

import kz.greetgo.eschool.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student deleteById(Long id);
    Student addStudent(Student student);
}
