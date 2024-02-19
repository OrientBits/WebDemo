package com.webdemo.controller;

import com.webdemo.entities.Student;
import com.webdemo.serviecs.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
        Student studentById = studentService.getStudentById(id);
        return new ResponseEntity<>(studentById, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> allStudent = studentService.getAllStudent();
        return new ResponseEntity<>(allStudent,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student){
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @Valid @RequestBody Student student){
        Student student1 = studentService.updateStudentById(id, student);
        return new ResponseEntity<>(student1,HttpStatus.ACCEPTED);
    }
    
}
