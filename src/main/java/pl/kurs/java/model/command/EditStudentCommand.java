package pl.kurs.java.model.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.kurs.java.model.State;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EditStudentCommand {

    private Integer id;
    private String name;
    private String surname;
    private String email;




}
