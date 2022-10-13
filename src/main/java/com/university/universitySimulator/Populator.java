package com.university.universitySimulator;

import com.university.universitySimulator.Model.Course;
import com.university.universitySimulator.Model.Instructor;
import com.university.universitySimulator.Repo.CourseRepository;
import com.university.universitySimulator.Repo.InstructorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {
    private CourseRepository courseRepo;
    private InstructorRepository instructorRepo;

    public Populator(CourseRepository courseRepo, InstructorRepository instructorRepo) {
        this.courseRepo = courseRepo;
        this.instructorRepo =instructorRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Instructor instructor1 = new Instructor("Rickie", "CSE");
        instructorRepo.save(instructor1);
        Instructor instructor2 = new Instructor("El", "CIS");
        instructorRepo.save(instructor2);
        Instructor instructor3 = new Instructor("Josh", "CSE");
        instructorRepo.save(instructor3);

        Course course1 = new Course("Java", 3, 60, "Fall 2022", instructor1);
        courseRepo.save(course1);
        Course course2 = new Course("c#",4,60, "Spring 2023", instructor2);
        courseRepo.save(course2);
        Course course3 = new Course("Intro to lollygagging", 7, 180,"Spring 2023", instructor3);
        courseRepo.save(course3);
        Course course4 = new Course("Intro to Tomfoolery", 6, 120,"Spring 2023", instructor3);
        courseRepo.save(course4);

    }



}
