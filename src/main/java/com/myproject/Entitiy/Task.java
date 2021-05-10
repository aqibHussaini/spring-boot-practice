package com.myproject.Entitiy;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class Task {

    private int id;
    @NotBlank(message="name must be not null")
    @Pattern(regexp = "^[a-zA-Z]+[\\-'\\s]?[a-zA-Z ]+$",message = "invalid name")
    @Size(min = 6, max = 15,message = "name characters must be between 6 and 15")
    private String name;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @NotBlank(message="description must be not null")
    @Size(min=10,max = 20,message = "name characters must be between 6 and 15")
    private String description;
    @NotBlank(message = "comments must not be null")
    @Size(min = 10,max = 20,message = "comments must be between 10 to 20 charactors")
    private String comments;
    private Date date;

    public Task(String name, String description, String comments, Date date) {
        this.name = name;
        this.description = description;
        this.comments = comments;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                ", date=" + date +
                '}';
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Task() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task(String name, String description, Date date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public Task(int id, String name, String description, Date date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
    }
}
