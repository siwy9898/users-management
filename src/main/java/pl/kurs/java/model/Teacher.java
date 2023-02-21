package pl.kurs.java.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Teacher {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacherIdGenerator")
    @SequenceGenerator(name = "teacherIdGenerator", allocationSize = 200, initialValue = 100, sequenceName = "teacher_id_sequence")
    private int id;

    @Column
    String name;

    @Column
    String surname;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private State state;


    public Teacher(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Teacher(Teacher teacher) {
        this.name = getName();
        this.surname = getSurname();
        this.email = getEmail();
    }
}
