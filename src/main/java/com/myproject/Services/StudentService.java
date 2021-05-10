package com.myproject.Services;

import com.myproject.Entitiy.Student;

import java.util.List;

public interface StudentService {
  public List<Student> getAllStudents();
  public Student getStudentById(int id);
  public String deletestudent(int id);
  public String saveStudent(Student obj);
  public String updateStudent(Student obj,int id);

}
