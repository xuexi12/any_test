package com.test.module.domain;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private List<User> next;
}