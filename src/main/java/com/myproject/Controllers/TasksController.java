package com.myproject.Controllers;

import com.myproject.Entitiy.Task;
import com.myproject.Pojo.Message;
//import com.myproject.Services.taskService;
import com.myproject.Services.taskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/tasks")
public class TasksController {
    @Autowired
    private com.myproject.Services.taskService taskService;

    @GetMapping("/get-tasks")
    public ResponseEntity<Task> getAllTasks() {

        return new ResponseEntity(this.taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/get-task/{id}")
    public ResponseEntity<Message> getTask(@PathVariable int id) {
        ResponseEntity<Message> messageResponseEntity;
        try {
            messageResponseEntity = new ResponseEntity(this.taskService.getTask(id), HttpStatus.OK);
        } catch (Exception e) {
            messageResponseEntity = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return messageResponseEntity;
    }

    @PostMapping("/save-task")
    public ResponseEntity<Task> getTask(@RequestBody Task task) {
        task.setDate(new Date());
        return new ResponseEntity(this.taskService.saveTask(task), HttpStatus.OK);
    }

    @RequestMapping(value = "/form-task", method = RequestMethod.GET)
    public String taskForm(Model model, Task task) {
        model.addAttribute("task", task);
        return "task.html";
    }

    @PostMapping("/handler")
    public String taskForm(@Valid Task task, BindingResult result) {
        if (result.hasErrors()) {

            System.out.println(result.getFieldError("name") + "" + result.hasErrors() + result.hasFieldErrors() + result.hasFieldErrors("description"));
            return "task.html";
        }
        return "data.html";
    }

    @PutMapping("/update-task/{id}")
    public void updateTask(@RequestBody Task task, @PathVariable int id) {
        this.taskService.updateTask(task, id);
//        return  new ResponseEntity("updated ", HttpStatus.OK);
    }

    @DeleteMapping("/delete-task/{id}")
    public ResponseEntity updateTask(@PathVariable int id) {
        this.taskService.deleteTask(id);
        return new ResponseEntity("record has been deleted", HttpStatus.OK);
    }

}
