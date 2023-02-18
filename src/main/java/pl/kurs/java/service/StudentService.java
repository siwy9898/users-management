package pl.kurs.java.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.java.model.Student;
import pl.kurs.java.model.command.CreateStudentCommand;
import pl.kurs.java.model.command.EditStudentCommand;
import pl.kurs.java.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public Student save(CreateStudentCommand command) {
        return studentRepository.save(new Student(command.getName(), command.getSurname(), command.getEmail()));

    }


    public Student edit(EditStudentCommand command) {
        Student toEdit = studentRepository.findById(command.getId()).orElseThrow();
        toEdit.setName(command.getName());
        toEdit.setSurname(command.getSurname());
        toEdit.setEmail(command.getEmail());
        return studentRepository.saveAndFlush(toEdit);
    }


}
