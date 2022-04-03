package peaksoft.hibernatejpa.apis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peaksoft.hibernatejpa.model.entity.Student;
import peaksoft.hibernatejpa.services.StudentService;

import java.util.List;

/**
 * @author Beksultan
 */
@RestController
@RequestMapping("api/students")
@Setter @Getter
public class StudentApi {

    @Autowired
    private StudentService studentService;

    // find all
    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.findAll();
    }

    // save
    @PostMapping("/save")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    // find by id
    @GetMapping("/get/{studentId}") // api/students/get/1
    public Student findById(@PathVariable Long studentId) {
        return studentService.findById(studentId);
    }

    // delete by id
    @DeleteMapping("/delete/{studentId}")
    public void deleteById(@PathVariable Long studentId) {
        studentService.deleteById(studentId);
    }

    // update
    @PutMapping("/update/{studentId}")
    public Student update(@PathVariable Long studentId,
                          @RequestBody Student newStudent) {
        return studentService.update(studentId, newStudent);
    }
}
