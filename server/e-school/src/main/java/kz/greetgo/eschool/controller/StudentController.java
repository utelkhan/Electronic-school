package kz.greetgo.eschool.controller;

import kz.greetgo.eschool.model.Student;
import kz.greetgo.eschool.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentController {
    private final StudentServiceImpl studentService;
    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @PostMapping
    @PermitAll
    @RequestMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public Student deleteUser(@PathVariable("id") Long id){
        return  studentService.deleteById(id);
    }

    @PutMapping
    @RequestMapping("/update")
    public Student update(@RequestBody Student student){
        return studentService.updateStudent(student);
    }
}
