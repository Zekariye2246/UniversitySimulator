package com.university.universitySimulator.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String studentName;
    private String major;

    @ManyToMany
    @JsonIgnore
    private Collection<Course> courses;

    public Student(String studentName, String major, Course... courses ) {
        this.studentName = studentName;
        this.major = major;
        this.courses = Arrays.asList(courses);
    }

    public Student() {
    }
    public void addCourseToStudent(Course course){
        courses.add(course);
    }

    public long getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getMajor() {
        return major;
    }

    public Collection<Course> getCourses() {
        return courses;
    }

}
