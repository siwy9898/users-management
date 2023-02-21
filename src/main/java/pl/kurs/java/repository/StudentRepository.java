package pl.kurs.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.kurs.java.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
