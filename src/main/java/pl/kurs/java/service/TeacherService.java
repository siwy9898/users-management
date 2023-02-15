package pl.kurs.java.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kurs.java.model.Teacher;
import pl.kurs.java.model.command.CreateTeacherCommand;
import pl.kurs.java.repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public Teacher save(CreateTeacherCommand command) {
        return teacherRepository.save(new Teacher(command.getName(), command.getSurname(), command.getEmail()));
    }

    @Transactional
    public void save(List<CreateTeacherCommand> commands) {
        commands.forEach(this::save);

    }




}
