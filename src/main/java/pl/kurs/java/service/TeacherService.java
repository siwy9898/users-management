package pl.kurs.java.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.java.model.Teacher;
import pl.kurs.java.model.command.CreateTeacherCommand;
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

    public Teacher delete (Integer id) {
        Teacher toDelete = teacherRepository.findById(id).orElseThrow();
        toDelete.setDeleted(true);

        return teacherRepository.saveAndFlush(toDelete);
    }

}
