package pl.kurs.java.config.converters;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;
import pl.kurs.java.model.Teacher;
import pl.kurs.java.model.dto.TeacherDto;

@Service
public class TeacherToTeacherDtoConverter implements Converter<Teacher, TeacherDto> {
    @Override
    public TeacherDto convert(MappingContext<Teacher, TeacherDto> mappingContext) {
        Teacher source = mappingContext.getSource();
        TeacherDto result = TeacherDto.builder()
                .id(source.getId())
                .name(source.getName())
                .surname(source.getSurname())
                .email(source.getEmail())
                .build();
        return result;
    }
}
