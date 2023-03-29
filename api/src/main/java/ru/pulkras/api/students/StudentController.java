package ru.pulkras.api.students;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/students")
public class StudentController {


    private final StudentService studentService;
    private final StudentRepository studentRepository;

    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @GetMapping(path = "list")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping(path = "item")
    public List<Student> addStudent(@RequestBody Student student) {
        studentService.add(student);
        return studentService.getStudents();
    }

    @DeleteMapping(path = "item/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.delete(studentId);
    }

    @PutMapping(path = "item/{studentId}")
    public void updateStudent(@RequestBody Student student) {
        Optional<Student> row = studentRepository.findById(student.getId());
        if(row.isPresent()) {
            Student item = row.get();
            if(!student.getName().isEmpty()) {
                item.setName(student.getName());
            } if(student.getDate() != null) {
                item.setDate(student.getDate());
            }
            studentRepository.save(item);
        }
    }
}

