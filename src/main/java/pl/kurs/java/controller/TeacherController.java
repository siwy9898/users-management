package pl.kurs.java.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.java.model.Teacher;
import pl.kurs.java.model.command.CreateTeacherCommand;
import pl.kurs.java.model.command.EditTeacherCommand;
import pl.kurs.java.model.view.TeacherView;
import pl.kurs.java.service.TeacherService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
@Slf4j
@RequiredArgsConstructor

public class TeacherController {

    private List<Teacher> teachers = Collections.synchronizedList(new ArrayList<>());

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity saveTeacher(@RequestBody CreateTeacherCommand command) {
        log.info("saveTeacher({})", command);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TeacherView(teacherService.save(command)));
    }

    @PutMapping
    public ResponseEntity editTeacher(@PathVariable int id, @RequestBody EditTeacherCommand command) {
        log.info("editTeacher({})", id, command);
        Teacher toEdit = teachers.stream()
                .filter(s -> s.getId() == id)
                .map(Teacher.class::cast)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("This teacher is not exists."));
        toEdit.setName(command.getName());
        toEdit.setSurname(command.getSurname());
        return ResponseEntity.status(HttpStatus.OK).body(toEdit);

    }


}
