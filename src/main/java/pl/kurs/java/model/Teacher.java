package pl.kurs.java.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacherIdGenerator")
    @SequenceGenerator(name = "teacherIdGenerator", allocationSize = 200, initialValue = 100, sequenceName = "teacher_id_sequence")
    private int id;

    private String name;
    private String surname;
    @Column(unique = true)
    private String email;

    @Version
    private long version;

    private boolean deleted;

    public Teacher (String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }



}
