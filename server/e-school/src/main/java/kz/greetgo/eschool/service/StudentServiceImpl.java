package kz.greetgo.eschool.service;

import kz.greetgo.eschool.model.Student;
import kz.greetgo.eschool.repository.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    private StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public final List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        try {
            studentList = studentMapper.findAllStudents();
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return studentList;
        }
        log.info("The students list was found correctly!");
        return studentList;
    }

    public Student deleteById(Long id) {
        final Student student= studentMapper.findById(id);
        try {
            studentMapper.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return student;
        }
        log.info("The student with id:" + id + " has been successfully deleted!");
        return student;
    }

    public Student addStudent(Student student) {
        try {
            Student lastStudent=findAll().get(studentMapper.findAllStudents().size()-1);
            student.setId(lastStudent.getId()+1);
            studentMapper.insert(student);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return student;
        }
        log.info("\nThe student:" + student.toString() + " has been successfully added!");
        return student;
    }

    public Student updateStudent(Student student) {
        try {
            studentMapper.update(student);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return student;
        }
        log.info("\nThe student:" + student.toString() + " has been successfully updated!");
        return student;
    }
}
