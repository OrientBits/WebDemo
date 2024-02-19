package com.webdemo.serviecs;

import com.webdemo.entities.Student;

import java.util.List;

public interface StudentService {

    public Student getStudentById(int id);

    public List<Student> getAllStudent();

    public Student saveStudent(Student student);

    public Student updateStudentById(int id, Student student);
}
