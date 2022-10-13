package com.university.universitySimulator.Model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Instructor {
    @Id
    @GeneratedValue
    private long id;
    private String instructorName;
    private String department;

    @OneToMany(mappedBy = "instructor")
    private Collection<Course> courses;

    public Instructor(String instructorName, String department) {
        this.instructorName = instructorName;
        this.department = department;
    }
    public Instructor(){

    }

    public long getId() {
        return id;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getDepartment() {
        return department;
    }

    public Collection<Course> getCourses() {
        return courses;
    }
}
