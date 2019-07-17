package com.tw.apistackbase.model;


import javax.persistence.*;

@Entity
public class CaseDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255,nullable = false)
    private String subjectiveRequirement;

    @Column(length = 255,nullable = false)
    private String objectiveRequirement;

    public CaseDescription() {
    }

    public CaseDescription(String subjectiveRequirement, String objectiveRequirement) {
        this.subjectiveRequirement = subjectiveRequirement;
        this.objectiveRequirement = objectiveRequirement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectiveRequirement() {
        return subjectiveRequirement;
    }

    public void setSubjectiveRequirement(String subjectiveRequirement) {
        this.subjectiveRequirement = subjectiveRequirement;
    }

    public String getObjectiveRequirement() {
        return objectiveRequirement;
    }

    public void setObjectiveRequirement(String objectiveRequirement) {
        this.objectiveRequirement = objectiveRequirement;
    }
}
