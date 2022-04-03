package peaksoft.hibernatejpa.services;

import org.springframework.stereotype.Service;
import peaksoft.hibernatejpa.model.Student;
import peaksoft.hibernatejpa.repository.StudentRepository;

import java.util.List;

/**
 * @author Beksultan
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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

    public void deleteById(Long studentId) {
        assert studentRepository.existsById(studentId);

        studentRepository.deleteById(studentId);
    }

    public Student update(Long studentId, Student newStudent) {

        Student student = studentRepository.findById(studentId).get();

        newStudent.setId(student.getId());

        return studentRepository.save(newStudent);
    }
}
