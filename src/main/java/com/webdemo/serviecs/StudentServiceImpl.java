package com.webdemo.serviecs;

import com.webdemo.entities.Student;
import com.webdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentById(int id) {
        Optional<Student> byId = studentRepository.findById(id);
        return byId.orElseGet(Student::new);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudentById(int id, Student student) {
        Optional<Student> byId = studentRepository.findById(id);
        if (byId.isPresent()){
            Student student1 = byId.get();
            student1.setName(student.getName());
            student1.setCourse(student.getCourse());
            student1.setClasses(student.getClasses());
            return studentRepository.save(student1);
        }
        return new Student();
    }
}
