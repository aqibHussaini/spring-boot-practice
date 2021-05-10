package com.myproject.Controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/Employee",method = RequestMethod.GET)
public class EmployeeController {
    @GetMapping("/home")
 public String home()
 {
     return "hello this is home!!!!";
 }
    @GetMapping("/getEmployees")
    public String getAllEmployee()
    {
        List<EmployeeController> employees=new ArrayList<>();
        return "hello this is home!!!!";
    }
}
