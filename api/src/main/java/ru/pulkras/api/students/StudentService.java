package ru.pulkras.api.students;

import org.springframework.stereotype.Service;
import ru.pulkras.api.response.RestApiException;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }


    public void add(Student student) {
        if(studentRepository.findStudentByEmail(student.getEmail()).isPresent()) {
            throw new RestApiException("email is busy");
        }
        studentRepository.save(student);
    }

    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public void update(Student student) {
        studentRepository.save(student);
    }
}
