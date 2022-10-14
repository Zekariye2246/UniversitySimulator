package com.university.universitySimulator.Controller;

import com.university.universitySimulator.Model.Course;
import com.university.universitySimulator.Model.Instructor;
import com.university.universitySimulator.Repo.CourseRepository;
import com.university.universitySimulator.Repo.InstructorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class InstructorController {
    private InstructorRepository instructorRepo;
    private CourseRepository courseRepo;

    public InstructorController(InstructorRepository instructorRepo, CourseRepository courseRepo) {

        this.instructorRepo = instructorRepo;
        this.courseRepo = courseRepo;

    }
    @GetMapping("/instructors")
    public Iterable<Instructor> getAllInstructors(){
        return instructorRepo.findAll();
    }
    @GetMapping("/instructors/{id}")
    public Instructor getSingleInstructor(@PathVariable long id){
        return instructorRepo.findById(id).get();
    }

   @PostMapping("/instructors")
   public Iterable<Instructor> addInstructor(@RequestBody Instructor instructor){
        instructorRepo.save(instructor);
        return instructorRepo.findAll();
    }
    @GetMapping("/instructors/{id}/getCourses")
    public Iterable<Course> getInstructorCourses(@PathVariable long id){
        return instructorRepo.findById(id).get().getCourses();
    }
    @PutMapping("/instructors/{id}/addToCourse/{courseId}")
    public Iterable<Instructor> addInstructorToCourse(@PathVariable long id, @PathVariable long courseId) throws Exception {
        Optional<Instructor> instructor = instructorRepo.findById(id);
        Optional<Course> course = courseRepo.findById(courseId);
        if (instructor.isPresent() && course.isPresent()) {
            course.get().setInstructor(instructor.get());
            courseRepo.save(course.get());
        }
        else {
            throw new Exception("Instructor/course does not exist");
        }
        return instructorRepo.findAll();
    }
}
