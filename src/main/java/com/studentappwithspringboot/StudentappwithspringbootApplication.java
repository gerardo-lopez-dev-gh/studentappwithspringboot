package com.studentappwithspringboot;

import com.studentappwithspringboot.service.IStudentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;

@SpringBootApplication
public class StudentappwithspringbootApplication implements CommandLineRunner {

  @Autowired private IStudentService studentService;
  private static final Logger looger =
      LoggerFactory.getLogger(StudentappwithspringbootApplication.class);
  String ln = System.lineSeparator();

  public static void main(String[] args) {
    looger.info("Starting the aplication");
    SpringApplication.run(StudentappwithspringbootApplication.class, args);
    looger.info("Application started successfully");
  }

  @Override
  public void run(String... args) throws Exception {
    looger.info("Executing the run method");
    System.out.println("Hola, mundo");
  }
}
