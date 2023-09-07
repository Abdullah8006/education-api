package com.abdullah.educationapi.repository;

import com.abdullah.educationapi.entity.Student;
import com.abdullah.educationapi.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

    List<StudentCourse> findByStudentIdAndCourseId(Long studentId, Long courseId);

    List<StudentCourse> findAllByStudent(Student student);
}
