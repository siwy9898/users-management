package pl.kurs.java.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentIdGenerator")
    @SequenceGenerator(name = "studentIdGenerator", allocationSize = 200, initialValue = 100, sequenceName = "student_id_sequence")
    private int id;

    String name;
    String surname;
    private String email;


    private boolean deleted = Boolean.FALSE;

    public Student(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Student(Student student) {
        this.name = getName();
        this.surname = getSurname();
        this.email = getEmail();

    }


}
