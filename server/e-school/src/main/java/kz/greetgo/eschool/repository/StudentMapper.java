package kz.greetgo.eschool.repository;


import kz.greetgo.eschool.model.AppUser;
import kz.greetgo.eschool.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM student")
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "grade", column = "grade"),
//            @Result(property = "first_name", column = "first_name"),
//            @Result(property = "last_name", column = "last_name"),
//            @Result(property = "age", column = "age"),
//            @Result(property = "average_rating", column = "average_rating")
//    })
    List<Student> findAllStudents();

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findById(Long id);

    @Delete("DELETE FROM student WHERE id = #{id}")
    void deleteById(Long id);

    @Insert("INSERT INTO student(id, grade, first_name, last_name, age, average_rating) VALUES (#{id}, #{grade}, #{first_name}, #{last_name}, #{age}, #{average_rating})")
    void insert(Student student);

    @Update("UPDATE student SET grade = #{grade}, first_name = #{first_name}, last_name = #{last_name}, age = #{age}, average_rating = #{average_rating} WHERE id = #{id}")
    void update(Student student);
}
