package com.studentappwithspringboot.repository;

import com.studentappwithspringboot.model.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findById(Long id);
}
