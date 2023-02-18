package pl.kurs.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.java.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
