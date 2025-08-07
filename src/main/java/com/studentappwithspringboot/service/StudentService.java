package com.studentappwithspringboot.service;

import com.studentappwithspringboot.model.Student;
import com.studentappwithspringboot.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {
  @Autowired
  private  StudentRepository studentRepository;

  @Override
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  @Override
  public Student findStudentById(Long id) {
    Optional<Student> student = studentRepository.findById(id);
    return (student.orElse(null));
  }

  @Override
  public Student saveStudent(Student student) {
    return studentRepository.save(student);
  }

  @Override
  public void deleteStudent(Student student) {
    studentRepository.delete(student);
  }
}
