package pl.kurs.java.model.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TeacherDto extends RepresentationModel<TeacherDto> {

    private int id;

    private String name;
    private String surname;
    private String email;


}
