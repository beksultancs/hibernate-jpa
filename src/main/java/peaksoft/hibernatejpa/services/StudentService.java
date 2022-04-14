package peaksoft.hibernatejpa.services;

import org.springframework.stereotype.Service;
import peaksoft.hibernatejpa.model.entity.Course;
import peaksoft.hibernatejpa.model.entity.Student;
import peaksoft.hibernatejpa.repository.CourseRepository;
import peaksoft.hibernatejpa.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Beksultan
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository,
                          CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Transactional
    public void deleteById(Long studentId) {
        assert studentRepository.existsById(studentId);

        Course course = courseRepository.findByStudentId(studentId).get();

        course.removeStudent(studentId);

        studentRepository.deleteById(studentId);
    }

    public Student update(Long studentId, Student newStudent) {

        Student student = studentRepository.findById(studentId).get();

        newStudent.setId(student.getId());

        return studentRepository.save(newStudent);
    }
}
