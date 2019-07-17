package com.tw.apistackbase.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;


    @OneToMany
    private List<Inquisitor> inquisitors;

    public Court() {
    }

    public Court(String name, List<Inquisitor> inquisitors) {
        this.name = name;
        this.inquisitors = inquisitors;
    }

    public List<Inquisitor> getInquisitors() {
        return inquisitors;
    }

    public void setInquisitors(List<Inquisitor> inquisitors) {
        this.inquisitors = inquisitors;
    }

    public Court(String name) {
        this.name = name;
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
