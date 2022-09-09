package com.fundamentos.springboot.fundamentos.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "user")
@Data
public class UserPojo {

    private String email;

    private String password;

    private String age;

    public UserPojo( String email, String password, String age) {
        this.email = email;
        this.password = password;
        this.age = age;
    }
}
