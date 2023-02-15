package pl.kurs.java.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.java.model.Student;
import pl.kurs.java.model.command.CreateStudentCommand;
import pl.kurs.java.model.command.EditStudentCommand;
import pl.kurs.java.model.view.StudentView;
import pl.kurs.java.service.StudentService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@Slf4j
@RequiredArgsConstructor

public class StudentController {
    private List<Student> students = Collections.synchronizedList(new ArrayList<>());

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity saveStudent(@RequestBody CreateStudentCommand command) {
        log.info("saveStudent({})", command);
        return ResponseEntity.status(HttpStatus.CREATED).body(new StudentView(studentService.save(command)));
    }

    @PutMapping
    public ResponseEntity editStudent(@PathVariable int id, @RequestBody EditStudentCommand command) {
        log.info("editStudent({})", id, command);
        Student toEdit = students.stream()
                .filter(s -> s.getId() == id)
                .map(Student.class::cast)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("This student is not exists."));
        toEdit.setName(command.getName());
        toEdit.setSurname(command.getSurname());
        return ResponseEntity.status(HttpStatus.OK).body(toEdit);

    }


}

