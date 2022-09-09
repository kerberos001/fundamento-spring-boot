package com.fundamentos.springboot.fundamentos.component;

@org.springframework.stereotype.Component
public class ComponentImplement implements  ComponentDependency {



    public void saludar() {
        System.out.println("Hola Spring Boot 2");

    }
}
