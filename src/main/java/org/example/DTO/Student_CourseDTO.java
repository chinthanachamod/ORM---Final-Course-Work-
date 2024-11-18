package org.example.DTO;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.Entity.Course;
import org.example.Entity.Student;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Data

public class Student_CourseDTO {
    private String student_course_id;
    private StudentDTO student;
    private CourseDTO course;
    private Date registration_date;
}
