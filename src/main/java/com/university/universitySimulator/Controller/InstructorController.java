package com.university.universitySimulator.Controller;

import com.university.universitySimulator.Model.Instructor;
import com.university.universitySimulator.Repo.InstructorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorController {
    private InstructorRepository instructorRepo;

    public InstructorController(InstructorRepository instructorRepo) {

        this.instructorRepo = instructorRepo;
    }
    @GetMapping("/instructors")
    public Iterable<Instructor> getAllInstructprs(){
        return instructorRepo.findAll();
    }
    @GetMapping("/instructors/{id}")
    public Instructor getSingleInstructor(@PathVariable long id){
        return instructorRepo.findById(id).get();
    }

}
