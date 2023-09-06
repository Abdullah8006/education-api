package com.abdullah.educationapi.repository;

import com.abdullah.educationapi.entity.Course;
import com.abdullah.educationapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
