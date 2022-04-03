package peaksoft.hibernatejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.hibernatejpa.model.Student;

/**
 * @author Beksultan
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
