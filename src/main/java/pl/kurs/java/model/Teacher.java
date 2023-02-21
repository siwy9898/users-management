package pl.kurs.java.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SQLDelete(sql = "update teacher set deleted = true where id = ?") // Sprawdzic czy bez controllera
@Where(clause = "deleted=false")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacherIdGenerator")
    @SequenceGenerator(name = "teacherIdGenerator", allocationSize = 200, initialValue = 100, sequenceName = "teacher_id_sequence")
    private int id;

    private String name;
    private String surname;
    @Column(unique = true)
    private String email;

    private boolean deleted;


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
