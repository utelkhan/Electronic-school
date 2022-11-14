package kz.greetgo.eschool.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Student implements Serializable {
    private Long id;
    private int grade;
    private String first_name;
    private String last_name;
    private int age;
    private double average_rating;
}
