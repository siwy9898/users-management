package pl.kurs.java.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.kurs.java.model.Student;
import pl.kurs.java.model.command.CreateStudentCommand;
import pl.kurs.java.model.command.EditStudentCommand;
import pl.kurs.java.model.dto.StudentDto;
import pl.kurs.java.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
@Slf4j
@RequiredArgsConstructor

public class StudentController {

    private final StudentService studentService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity saveStudent(@RequestBody CreateStudentCommand command) {
        log.info("saveStudent({})", command);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(studentService.save(command), StudentDto.class));
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> editStudent(@PathVariable long id, @RequestBody EditStudentCommand command) {
        log.info("editStudent({})", command);
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(studentService.edit(command), StudentDto.class));
    }






}

