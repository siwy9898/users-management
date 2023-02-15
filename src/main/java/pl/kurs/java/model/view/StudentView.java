package pl.kurs.java.model.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kurs.java.model.Student;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StudentView {

    @Id
    private int id;
    private String name;
    private String surname;
    private String email;

    public StudentView(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.surname = student.getSurname();
        this.email = student.getEmail();
    }
}
