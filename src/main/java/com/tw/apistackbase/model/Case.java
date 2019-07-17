package com.tw.apistackbase.model;



import javax.persistence.*;

@Entity
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255, nullable = false)
    private String caseName;      // 长度在0~255之间
    @Column(nullable = false)
    private Long time;

    @OneToOne(cascade = CascadeType.ALL)
    private CaseDescription description;

    public Case() {
    }

    public Case(String caseName, Long time) {
        this.caseName = caseName;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public CaseDescription getDescription() {
        return description;
    }

    public void setDescription(CaseDescription description) {
        this.description = description;
    }
}
