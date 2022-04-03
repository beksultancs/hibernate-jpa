package peaksoft.hibernatejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.hibernatejpa.model.entity.Course;

import java.util.Optional;

/**
 * @author Beksultan
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select c from Course c join c.students s where s.id = ?1")
    Optional<Course> findByStudentId(Long studentId);
}
