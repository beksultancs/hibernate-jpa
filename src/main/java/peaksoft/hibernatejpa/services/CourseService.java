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
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseService(CourseRepository courseRepository,
                         StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(Long courseId) {
        return courseRepository.findById(courseId).get();
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void deleteById(Long courseId) {
        assert courseRepository.existsById(courseId);
        courseRepository.deleteById(courseId);
    }

    public Course update(Long courseId, Course newCourse) {
        assert courseRepository.existsById(courseId);

        newCourse.setId(courseId);

        return courseRepository.save(newCourse);
    }

    @Transactional
    public Course addStudentToCourse(Long courseId, Student student) {
        Course course = courseRepository.findById(courseId).get();

        Student student1 = studentRepository.save(student);

        student1.setCourse(course);
        course.addStudent(student1);

        return course;
    }

    @Transactional
    public Course addStudentToCourseByIds(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId).get();

        Student student = studentRepository.findById(studentId).get();

        student.setCourse(course);
        course.addStudent(student);

        return course;
    }
}
