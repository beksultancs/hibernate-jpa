package peaksoft.hibernatejpa.apis;

import org.springframework.web.bind.annotation.*;
import peaksoft.hibernatejpa.model.entity.Course;
import peaksoft.hibernatejpa.model.entity.Student;
import peaksoft.hibernatejpa.services.CourseService;

import java.util.List;

/**
 * @author Beksultan
 */
@RestController
@RequestMapping("api/courses")
public class CourseApi {

    private final CourseService courseService;

    public CourseApi(CourseService courseService) {
        this.courseService = courseService;
    }

    // find all
    @GetMapping
    public List<Course> findAll() {
        return courseService.findAll();
    }

    // find by id
    @GetMapping("/find/{courseId}")
    public Course findbyId(@PathVariable Long courseId) {
        return courseService.findById(courseId);
    }

    // save
    @PostMapping("/save")
    public Course save(@RequestBody Course course) {
        return courseService.save(course);
    }

    // delete
    @DeleteMapping("/delete/{courseId}")
    public void deleteById(@PathVariable Long courseId) {
        courseService.deleteById(courseId);
    }

    // update
    @PutMapping("/update/{courseId}")
    public Course update(@PathVariable Long courseId,
                         @RequestBody Course newCourse) {
        return courseService.update(courseId, newCourse);
    }

    @PostMapping("/{courseId}/add/student")
    public Course addStudentToCourseByCourseId(@PathVariable Long courseId,
                                               @RequestBody Student student) {
        System.out.println(student);
        return courseService.addStudentToCourse(courseId, student);
    }

    @PostMapping("/{courseId}/add/{studentId}")
    public Course addStudentToCourseByIds(@PathVariable Long courseId,
                                          @PathVariable Long studentId) {
        return courseService.addStudentToCourseByIds(courseId, studentId);
    }
}

