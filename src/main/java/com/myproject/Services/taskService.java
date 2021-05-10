package com.myproject.Services;

import com.myproject.Entitiy.Task;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class taskService {
   private List<Task> tasks;

    public taskService(List<Task> tasks) {
        Task task=new Task(1,"hard work","keep doing hard work",new Date());
        tasks.add(task);
         task=new Task(2,"angular form","angular form validation",new Date());
        tasks.add(task);
         task=new Task(3,"spring mvc form validation","do spring mvc form validation",new Date());
        tasks.add(task);
         task=new Task(4,"do fyp","keep doing hard work on fyp",new Date());
        tasks.add(task);
        this.tasks = tasks;
    }

    public List<Task> getAllTasks()
    {
        return this.tasks;
    }
    public Task getTask(int id)
    {
        return this.tasks.stream().filter(t->t.getId()==1).findFirst().orElse(null);
    }
    public Task saveTask(Task obj)
    {
        this.tasks.add(obj);
        return obj;
    }
    public void deleteTask(int id)
    {
//       Task task= this.tasks.stream().filter(t->t.getId()==id).findFirst().orElse(null);
//        this.tasks.remove(task);
         this.tasks=this.tasks.stream().filter(t->{
            if( t.getId()==id)
                return false;
             return true;
         }).collect(Collectors.toList());

    }

    public void updateTask(Task obj,int id)
    {
        this.tasks= this.tasks.stream().map(t->{
            if(t.getId()==id)
            {
                t.setId(obj.getId());
                t.setName(obj.getName());
                t.setDescription(obj.getDescription());
                t.setDate(obj.getDate());
                return t;
            }
            else
            {
                return t;
            }
        }).collect(Collectors.toList());
        System.out.println(this.tasks);
//        return obj;

    }

}
