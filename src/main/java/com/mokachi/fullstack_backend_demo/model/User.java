package com.mokachi.fullstack_backend_demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String username;
    private String email;
}
