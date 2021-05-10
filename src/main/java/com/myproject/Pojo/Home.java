package com.myproject.Pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Home {
    public Home() {
        System.out.println("object created...");
    }
}
