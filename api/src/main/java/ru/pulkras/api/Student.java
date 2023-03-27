package ru.pulkras.api;

import java.time.LocalDate;

public class Student {

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
}
