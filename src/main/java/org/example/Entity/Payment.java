
package org.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Payment {
    @Id
    private String pay_id;
    private String pay_date;
    private double pay_amount;

    @ManyToOne
    @JoinColumn(name = "student_course_id")
    private Student_Course student_course;
}
