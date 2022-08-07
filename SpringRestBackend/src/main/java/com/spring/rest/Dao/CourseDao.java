package com.spring.rest.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.entity.Course;

public interface CourseDao extends JpaRepository<Course,Long>{

}
