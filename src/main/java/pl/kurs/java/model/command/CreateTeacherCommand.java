package pl.kurs.java.model.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class CreateTeacherCommand {

    private String name;
    private String surname;
    private String email;


}
