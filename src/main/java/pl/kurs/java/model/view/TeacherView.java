package pl.kurs.java.model.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kurs.java.model.Teacher;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TeacherView {

    @Id
    private int id;
    private String name;
    private String surname;
    private String email;

    public  TeacherView (Teacher teacher){
        this.id=teacher.getId();
        this.name=teacher.getName();
        this.surname=teacher.getSurname();
        this.email=teacher.getEmail();
    }
}
