package pl.kurs.java.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StudentDto extends RepresentationModel <StudentDto> {

    private int id;

    private String name;
    private String surname;
    private String email;


}
