package pl.kurs.java.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.java.model.command.CreateTeacherCommand;
import pl.kurs.java.model.command.EditTeacherCommand;
import pl.kurs.java.model.dto.StudentDto;
import pl.kurs.java.model.dto.TeacherDto;
import pl.kurs.java.service.TeacherService;

@RestController
@RequestMapping("/api/v1/teachers")
@Slf4j
@RequiredArgsConstructor

public class TeacherController {


    private final TeacherService teacherService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity saveTeacher(@RequestBody CreateTeacherCommand command) {
        log.info("saveTeacher({})", command);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(teacherService.save(command), TeacherDto.class));
    }

    @PutMapping
    public ResponseEntity editTeacher(@PathVariable long id, @RequestBody EditTeacherCommand command) {
        log.info("editTeacher({})", command);

        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(teacherService.edit(command), StudentDto.class));

    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<TeacherDto> deleteTeacher(@PathVariable Integer id, @RequestBody EditTeacherCommand command) {
        log.info("deleteTeacher({})", command);
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(teacherService.delete(id), TeacherDto.class));

    }

}
