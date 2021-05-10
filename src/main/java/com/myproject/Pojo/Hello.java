package com.myproject.Pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Hello {
    public Hello() {
        System.out.println("object created");
    }
}
