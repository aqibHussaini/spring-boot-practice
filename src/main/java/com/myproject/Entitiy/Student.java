package com.myproject.Entitiy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name,classname,email,password;
//    @ElementCollection
//    @Column(name = "subjects", nullable = false)
//    private List<String> subjects = new ArrayList<String>();
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classname='" + classname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                  +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Student(int id, String name, String classname, String email, String password) {
        this.id = id;
        this.name = name;
        this.classname = classname;
        this.email = email;
        this.password = password;
    }

    public Student() {
    }
}
