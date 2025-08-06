package com.studentappwithspringboot;

import com.studentappwithspringboot.model.Student;
import com.studentappwithspringboot.service.IStudentService;
import java.util.List;
import java.util.Scanner;
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
    looger.info(ln + "Executing the run method" + ln);
    looger.info("Welcome to the Student Management System!");
    boolean exit = false;
    Scanner scanner = new Scanner(System.in);
    while (!exit) {
      looger.info("----------------------------------");
      looger.info(ln);
      showMenu();
      try {
        exit = executeOption(scanner, studentService);
      } catch (Exception e) {
        looger.info("An error occurred: " + e.getMessage());
      }
    }
  }

  private void showMenu() {
    looger.info(
        """
                1. List all students
                2. Find student by ID
                3. Add new student
                4. Update student
                5. Delete student
                6. Exit
            """);
    looger.info("Please select an option (1-6): ");
  }

  private boolean executeOption(Scanner scanner, IStudentService studentService) {
    var option = scanner.nextInt();
    boolean exit = false;
    switch (option) {
      case 1 -> {
        looger.info("Listing all students:");
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
          looger.info("No students found." + ln);
        } else {
          students.forEach((student -> looger.info(student.toString())));
        }
      }
      case 2 -> {
        looger.info("Enter student ID to find:" + ln);
        Long id = scanner.nextLong();
        Student student = studentService.findStudentById(id);
        if (student != null) {
          looger.info("Student found: " + student.toString() + ln);
        } else {
          looger.info("Student not found with ID: " + id + ln);
        }
      }
      case 3 -> {
        looger.info("Adding a new student:" + ln);
        Student newStudent = new Student();
        System.out.print("Name: ");
        newStudent.setName(scanner.next());
        System.out.print("Last Name: ");
        newStudent.setLastName(scanner.next());
        System.out.print("Phone Number: ");
        newStudent.setPhoneNumber(scanner.next());
        System.out.print("Email: ");
        newStudent.setEmail(scanner.next());
        Student savedStudent = studentService.saveStudent(newStudent);
        if (savedStudent != null) {
          looger.info("Student added successfully: " + savedStudent.toString() + ln);
        } else {
          looger.info("Failed to add student." + ln);
        }
      }
      case 4 -> {
        looger.info("Updating a student:" + ln);
        Student updateStudent = new Student();
        System.out.print("Enter student ID to update: " + ln);
        updateStudent.setId(scanner.nextLong());
        Student existingStudent = studentService.findStudentById(updateStudent.getId());
        updateStudentMethod(scanner, studentService, existingStudent, updateStudent);
      }
      case 5 -> {
        System.out.println("Deleting a student:");
        Student deleteStudent = new Student();
        System.out.print("Enter student ID to delete: ");
        deleteStudent.setId(scanner.nextInt());
        if (studentDAO.deleteStudent(deleteStudent)) {
          System.out.println("Student deleted successfully.");
        } else {
          System.out.println("Failed to delete student.");
        }
      }
      case 6 -> {
        System.out.println("Exiting the application. Goodbye!");
        exit = true;
      }
    }
    return exit;
  }

  private void updateStudentMethod(Scanner scanner, IStudentService studentService, Student existingStudent, Student updateStudent) {
    if (existingStudent != null) {
      looger.info("Enter new details (leave blank to keep current value):" + ln);
      System.out.print("Name (" + existingStudent.getName() + "): ");
      String name = scanner.next();
      if (!name.isBlank()) {
        existingStudent.setName(name);
      }
      System.out.print("Last Name (" + existingStudent.getLastName() + "): ");
      String lastName = scanner.next();
      if (!lastName.isBlank()) {
        existingStudent.setLastName(lastName);
      }
      System.out.print("Phone Number (" + existingStudent.getPhoneNumber() + "): ");
      String phoneNumber = scanner.next();
      if (!phoneNumber.isBlank()) {
        existingStudent.setPhoneNumber(phoneNumber);
      }
      System.out.print("Email (" + existingStudent.getEmail() + "): ");
      String email = scanner.next();
      if (!email.isBlank()) {
        existingStudent.setEmail(email);
      }
      Student updatedStudent = studentService.saveStudent(existingStudent);
      if (updatedStudent != null) {
        looger.info("Student updated successfully: " + updatedStudent.toString() + ln);
      } else {
        looger.info("Failed to update student." + ln);
      }
    } else {
        looger.info("Student not found with ID: " + updateStudent.getId() + ln);
    }
  }
}
