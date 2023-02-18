package pl.kurs.java.config.converters;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;
import pl.kurs.java.model.Student;
import pl.kurs.java.model.dto.StudentDto;

@Service
public class StudentToStudentDtoConverter implements Converter<Student, StudentDto> {
    @Override
    public StudentDto convert(MappingContext<Student, StudentDto> mappingContext) {
        Student source = mappingContext.getSource();
        StudentDto result = StudentDto.builder()
                .id(source.getId())
                .name(source.getName())
                .surname(source.getSurname())
                .email(source.getEmail())
                .build();
        return result;
    }
}
