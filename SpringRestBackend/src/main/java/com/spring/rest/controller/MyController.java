package com.spring.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entity.Course;
import com.spring.rest.service.CourceService;
import com.spring.rest.service.CourceServiceImple;

@RestController
@CrossOrigin  
public class MyController {

	//Need to add this annotation here because 
	//Access to XMLHttpRequest at 'http://localhost:8087/courses' from origin 'http://localhost:3000'
	// has been blocked by CORS policy:
	// No 'Access-Control-Allow-Origin' header is present on the requested resource.
	
	//was getting this error for network error 
	
	@Autowired
	private CourceService courceService;
	
	@GetMapping("/home")
	public String home() {
		
		return "Hello Courses";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
	
		
		return this.courceService.getCourses();
	}
	
	@GetMapping("/courses/{id}")
	public Optional<Course> getCourceWithId(@PathVariable("id") String CourceId) {
		
		
		return this.courceService.getCourse(Long.parseLong(CourceId)) ;
		
		
	}
	
	@PostMapping("/savecourse")
	public Course saveCource(@RequestBody Course course) {
		
		
		return this.courceService.saveCourse(course);
		
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		
		return this.courceService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("courseId") String courseId){
		
		try {
			this.courceService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
}
