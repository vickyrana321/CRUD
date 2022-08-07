package com.spring.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.rest.Dao.CourseDao;
import com.spring.rest.entity.Course;

@Service
public class CourceServiceImple implements CourceService {

	//List<Course> list;
	
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		List<Course> findAll = courseDao.findAll();
		return findAll;
	}

	@Override
	public Optional<Course> getCourse(long id) {
		// TODO Auto-generated method stub
//
//		Course c=null;
//		for(Course course:list) {
//			if(course.getId()==id) {
//				c=course;
//				break;
//			}
//		}
//	
	 
		return courseDao.findById(id);
	}

	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
//	    list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		Course entity=courseDao.getOne(parseLong);
		courseDao.delete(entity);
		
	}
	
	

}
