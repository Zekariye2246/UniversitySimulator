package com.university.universitySimulator.Controller;


import com.university.universitySimulator.Model.Course;
import com.university.universitySimulator.Model.Student;
import com.university.universitySimulator.Repo.CourseRepository;
import com.university.universitySimulator.Repo.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

    private StudentRepository studentRepo;
    private CourseRepository courseRepo;

    public StudentController(StudentRepository studentRepo,CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @GetMapping("/students")
    public Iterable<Student> getStudents(){
        return studentRepo.findAll();

    }

    @GetMapping("/students/{id}")
    public Student getSingleStudent(@PathVariable long id) {
        return studentRepo.findById(id).get();
    }

    @GetMapping("/students/{id}/getCourses")
    public Iterable<Course> getCourses(@PathVariable long id) {
        return studentRepo.findById(id).get().getCourses();
    }
    @PostMapping("/students")
    public Iterable<Student> addStudent(@RequestBody Student newStudent){
        studentRepo.save(newStudent);
        return studentRepo.findAll();
    }
    @PutMapping("/students/{id}/addToCourse/{courseId}")
    public Course addStudentToCourse(@PathVariable long id, @PathVariable long courseId) throws Exception {
        Optional<Student> student = studentRepo.findById(id);
        Optional<Course> course = courseRepo.findById(courseId);
        if(student.isPresent() && course.isPresent()) {
            student.get().addCourseToStudent(course.get());
            studentRepo.save(student.get());
        }
        else {
            throw new Exception("course/student not found");
        }
        return courseRepo.findById(courseId).get();
    }
}
