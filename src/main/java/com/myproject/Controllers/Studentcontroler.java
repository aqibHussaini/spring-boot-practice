package com.myproject.Controllers;

import com.myproject.Entitiy.Student;
import com.myproject.Services.StudentService;
import com.myproject.repositories.StudentRepo;
import com.myproject.utils.noStudentFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/student-app",method = RequestMethod.GET)
public class Studentcontroler  {
    @Autowired
    StudentService service;
    @Autowired
    StudentRepo studentRepo;
    @RequestMapping(value = "/getAllStudent",method = RequestMethod.GET)
    @CrossOrigin
    public List<Student> getAllStudent()
    {
        return this.service.getAllStudents();
    }
    @RequestMapping(value = "/getStudentById/{id}",method = RequestMethod.GET)
    @CrossOrigin
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) throws noStudentFound {
        Student obj=null;
        try
        {

          obj=this.service.getStudentById(id);
        }
        catch (Exception ex)
        {
            throw new noStudentFound("no student with this id available...");
        }
    return new ResponseEntity<Student>(obj, HttpStatus.OK);
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public String deletestudent(@PathVariable("id") int id)
    {
        return this.service.deletestudent(id);
    }
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public String updatestudent(@PathVariable("id") int id,@RequestBody Student student)
    {
        return  this.service.updateStudent(student,id);

    }
    @GetMapping("/search/{name}")
    public List<Student> search(@PathVariable String name)
    {
        return this.studentRepo.search(name);
    }
    @RequestMapping(value = "/patchupdate/{id}",method = RequestMethod.PATCH)
    public String patchstudent(@PathVariable("id") int id,@RequestBody Map<Object,Object> field)
    {
        Student std=this.service.getStudentById(id);
        field.forEach((k,v)->{
            Field myfield= ReflectionUtils.findField(Student.class, String.valueOf(k));
            myfield.setAccessible(true);
            ReflectionUtils.setField(myfield,std,v);
        });
    return this.service.updateStudent(std,id);
    }
    @RequestMapping(value="/savestudent",method=RequestMethod.POST)
    public  String saveStudent(@RequestBody Student student)
    {
        return this.service.saveStudent(student);
    }

}
