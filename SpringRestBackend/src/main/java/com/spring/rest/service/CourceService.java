package com.spring.rest.service;

import java.util.List;
import java.util.Optional;

import com.spring.rest.entity.Course;

public interface CourceService {

	public List<Course> getCourses();
	public Optional<Course> getCourse(long id);
	public Course saveCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(long parseLong);
}
