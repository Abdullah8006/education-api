package com.abdullah.educationapi.repository;

import com.abdullah.educationapi.entity.Course;
import com.abdullah.educationapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("Select s from Student s join s.courses sc where sc.course IN (:courses)")
    List<Student> findByCourses(List<Course> courses);
    
}
