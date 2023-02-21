package pl.kurs.java.model.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class StudentDto extends RepresentationModel<StudentDto> {

    private int id;

    private String name;
    private String surname;
    private String email;


}
