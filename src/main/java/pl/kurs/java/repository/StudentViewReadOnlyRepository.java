package pl.kurs.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.java.model.view.StudentView;

public interface StudentViewReadOnlyRepository extends JpaRepository<StudentView, Integer> {
}
