package com.myproject.Entitiy;

public class Todo {
    int id;
    private String tittle,description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Todo(int id, String tittle, String description) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
    }
}
