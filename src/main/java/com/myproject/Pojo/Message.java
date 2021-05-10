package com.myproject.Pojo;

import com.myproject.Entitiy.Task;

public class Message {
    private String msg;
    private Task task;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Message(String msg, Task task) {
        this.msg = msg;
        this.task = task;
    }
}
