package pl.kurs.java.model.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CreateStudentCommand {

    private String name;
    private String surname;
    private String email;

}
