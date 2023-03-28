package ru.pulkras.api.students;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private long id;

    private String name;

    private LocalDate date;


    public Student() {

    }

    public Student(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
