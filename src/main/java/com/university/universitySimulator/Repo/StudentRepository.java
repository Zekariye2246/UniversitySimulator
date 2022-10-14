package com.university.universitySimulator.Repo;

import com.university.universitySimulator.Model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
