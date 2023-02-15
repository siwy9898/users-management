package pl.kurs.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.java.model.Teacher;
import pl.kurs.java.model.view.TeacherView;

public interface TeacherViewReadOnlyRepository extends JpaRepository<TeacherView, Integer> {
}
