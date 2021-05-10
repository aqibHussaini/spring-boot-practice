package com.myproject.Services;

import com.myproject.Entitiy.Student;
import com.myproject.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplementation implements StudentService {
List<Student> list=new ArrayList<Student>();
    @Autowired
    StudentRepo studentRepository;
    public StudentServiceImplementation(List<Student> list) {

//        list.add(new Student(1,"ali","mcs","ali@gmail.com","ali123",List.of("C","CPP","Java")));
//        list.add(new Student(2,"aqib","mcs","aqib@gmail.com","aqib123",List.of("C","CPP","Java")));
//        list.add(new Student(3,"waqas","bcom","waqas@gmail.com","waqas123",List.of("Accounting","Business")));
//        list.add(new Student(1,"ali","mcs","ali@gmail.com","ali123",List.of("C","CPP","Java")));
//        list.add(new Student(2,"aqib","mcs","aqib@gmail.com","aqib123",List.of("C","CPP","Java")));
//        list.add(new Student(3,"waqas","bcom","waqas@gmail.com","waqas123",List.of("Accounting","Business")));
//        list.add(new Student(1,"ali","mcs","ali@gmail.com","ali123",List.of("C","CPP","Java")));
//        list.add(new Student(2,"aqib","mcs","aqib@gmail.com","aqib123",List.of("C","CPP","Java")));
//        list.add(new Student(3,"waqas","bcom","waqas@gmail.com","waqas123",List.of("Accounting","Business")));
//        list.add(new Student(1,"ali","mcs","ali@gmail.com","ali123",List.of("C","CPP","Java")));
//        list.add(new Student(2,"aqib","mcs","aqib@gmail.com","aqib123",List.of("C","CPP","Java")));
//        list.add(new Student(3,"waqas","bcom","waqas@gmail.com","waqas123",List.of("Accounting","Business")));
//        list.add(new Student(1,"ali","mcs","ali@gmail.com","ali123",List.of("C","CPP","Java")));
//        list.add(new Student(2,"aqib","mcs","aqib@gmail.com","aqib123",List.of("C","CPP","Java")));
//        list.add(new Student(3,"waqas","bcom","waqas@gmail.com","waqas123",List.of("Accounting","Business")));
//        list.add(new Student(1,"ali","mcs","ali@gmail.com","ali123",List.of("C","CPP","Java")));
//        list.add(new Student(2,"aqib","mcs","aqib@gmail.com","aqib123",List.of("C","CPP","Java")));
//        list.add(new Student(3,"waqas","bcom","waqas@gmail.com","waqas123",List.of("Accounting","Business")));
//        list.add(new Student(1,"ali","mcs","ali@gmail.com","ali123",List.of("C","CPP","Java")));
//        list.add(new Student(2,"aqib","mcs","aqib@gmail.com","aqib123",List.of("C","CPP","Java")));
//        list.add(new Student(3,"waqas","bcom","waqas@gmail.com","waqas123",List.of("Accounting","Business")));
//        list.add(new Student(1,"ali","mcs","ali@gmail.com","ali123",List.of("C","CPP","Java")));
//        list.add(new Student(2,"aqib","mcs","aqib@gmail.com","aqib123",List.of("C","CPP","Java")));
//        list.add(new Student(3,"waqas","bcom","waqas@gmail.com","waqas123",List.of("Accounting","Business")));

        this.list = list;
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.getAll();
//        return  this.studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return this.studentRepository.getStudentByID(id);
//        Optional<Student> student =this.list.stream().filter((post)->{
//            if(post.getId()==id)
//                return true;
//            else
//                return false;
//        }).findFirst();
//        return student.get();
    }

    @Override
    public String deletestudent(int id) {
       list= this.list.stream().filter((obj)->{
           if(obj.getId()==id)
           {
               return false;
           }
           else
           {
               return true;
           }
       }).collect(Collectors.toList());
        return "Student with "+id+" has been deleted";
    }

    @Override
    public String saveStudent(Student obj) {
//        this.list.add(obj);
        this.studentRepository.saveStudent(obj.getName(),obj.getClassname(),obj.getEmail(),obj.getPassword());
        return "The data of student with name =  "+obj.getName()+" has been saved";
    }

    @Override
    public String updateStudent(Student obj, int id) {
        list=this.list.stream().map((student)->{
            if(student.getId()==id)
            {
                student.setClassname(obj.getClassname());
                student.setEmail(obj.getEmail());
                student.setPassword(obj.getPassword());
                student.setName(obj.getName());
            }
           return student;
        }).collect(Collectors.toList());
        return "data of student with id = "+id +" is modified.......";
    }
}
