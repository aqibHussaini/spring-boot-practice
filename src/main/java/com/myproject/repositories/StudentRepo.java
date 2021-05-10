package com.myproject.repositories;

import com.myproject.Entitiy.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    @Query("Select s from Student s where s.name like %:n%")
    List<Student> findByNameContaining(@Param("n")String n);
    @Query(value = "Select * from Student  where name like %:n%",nativeQuery = true)
    List<Student> search(@Param("n")String n);
//   List<Student> findByNameContaining(String name);
   List<Student> findByNameLike(String name);
    @Query(value = "select * from Student " ,nativeQuery = true)
   public List<Student> getAll();
//    @Query("select u from Student u")
//    public List<Student> getAll();
@Query(value = "select * from Student where id=?" ,nativeQuery = true)
public Student getStudentByID(@Param("id") int id);
    @Modifying
    @Transactional
    @Query(value = "insert into student(name,classname,email,password) values(?,?,?,?)" ,nativeQuery = true)
    public void saveStudent(@Param("name")String name,@Param("classname") String classname,@Param("email")String email,@Param("password") String password);
}
