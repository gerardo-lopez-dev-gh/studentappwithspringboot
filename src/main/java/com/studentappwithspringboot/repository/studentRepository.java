package com.studentappwithspringboot.repository;

import com.studentappwithspringboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<Student, Long> {

}
