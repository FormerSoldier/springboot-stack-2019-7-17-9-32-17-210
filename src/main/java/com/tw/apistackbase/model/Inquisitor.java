package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
public class Inquisitor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    public Inquisitor(String name) {
        this.name = name;
    }

    public Inquisitor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
