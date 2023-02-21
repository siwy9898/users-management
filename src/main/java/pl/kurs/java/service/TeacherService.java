package pl.kurs.java.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.java.model.State;
import pl.kurs.java.model.Student;
import pl.kurs.java.model.Teacher;
import pl.kurs.java.model.command.CreateTeacherCommand;
import pl.kurs.java.model.command.EditStudentCommand;
import pl.kurs.java.model.command.EditTeacherCommand;
import pl.kurs.java.repository.TeacherRepository;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public Teacher save(CreateTeacherCommand command) {
        return teacherRepository.save(new Teacher(command.getName(), command.getSurname(), command.getEmail()));
    }

    public Teacher edit(EditTeacherCommand command) {
        Teacher toEdit = teacherRepository.findById(command.getId()).orElseThrow();
        toEdit.setName(command.getName());
        toEdit.setSurname(command.getSurname());
        toEdit.setEmail(command.getEmail());
        return teacherRepository.saveAndFlush(toEdit);
    }

    public Teacher delete (EditStudentCommand command){
        Teacher toDelete = teacherRepository.findById(command.getId()).orElseThrow();
        toDelete.setState(State.DELETED);
        return teacherRepository.saveAndFlush(toDelete);
    }


}
