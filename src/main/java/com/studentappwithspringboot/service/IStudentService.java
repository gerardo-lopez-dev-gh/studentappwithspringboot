package com.studentappwithspringboot.service;

import com.studentappwithspringboot.model.Student;
import java.util.List;

public interface IStudentService {
    public List<Student> getAllStudents();
    public Student findStudentById(Long id);
    public Student saveStudent(Student student);
    public void deleteStudent(Student student);
    
}
