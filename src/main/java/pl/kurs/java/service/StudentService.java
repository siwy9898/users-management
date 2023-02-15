package pl.kurs.java.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kurs.java.model.Student;
import pl.kurs.java.model.command.CreateStudentCommand;
import pl.kurs.java.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student save(CreateStudentCommand command) {
        return studentRepository.save(new Student(command.getName(), command.getSurname(), command.getEmail()));

    }

    @Transactional
    public void save(List<CreateStudentCommand> commands) {
        commands.forEach(this::save);
    }
}
