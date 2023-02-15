package pl.kurs.java.model.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateStudentCommand {

    private String name;
    private String surname;
    private String email;

    public CreateStudentCommand(String[] args) {
        this.name = args[0];
        this.surname = args[1];
        this.email = args[2];
    }
}
