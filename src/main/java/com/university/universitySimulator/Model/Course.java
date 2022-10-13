package com.university.universitySimulator.Model;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private long id;
    private String courseName;
    private int creditHours;
    private int duration;
    private String semester;

    @ManyToOne
    private Instructor instructor;

    public Course(String courseName, int creditHours, int duration, String semester, Instructor instructor) {
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.duration = duration;
        this.semester = semester;
        this.instructor = instructor;
    }
    public Course() {

    }

    public long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public int getDuration() {
        return duration;
    }

    public String getSemester() {
        return semester;
    }

}
