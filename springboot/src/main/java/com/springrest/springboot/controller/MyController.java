package com.springrest.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springboot.entity.Course;
import com.springrest.springboot.services.CourseServices;

import io.swagger.annotations.ApiOperation;

@RestController
public class MyController {
    Logger logger = LoggerFactory.getLogger(MyController.class);
	
	@Autowired
	private CourseServices courseService;
	
	@GetMapping("/courses")
	public List<Course> getCourses(@RequestParam(name="name", required = false, defaultValue = "null") String name) {
		return this.courseService.getCourses();
	}
	
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}

	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{field}")
	public List<Course> findCoursesWithSort(@PathVariable String field) {
		  List<Course> allCourses = courseService.findCoursesWithSorting(field);
	        return allCourses;
	}
	
	@GetMapping("/coursesById/{courseId}")
	@ApiOperation("Returns Course based in course id .")
	public Course getById(@PathVariable long courseId) {
		System.out.println("invoked");
		return this.courseService.getById(courseId);
	}
	
	@GetMapping("/course")
    public List<Course> findByTitle(@RequestParam String title) {
        return courseService.getByTitle(title);
    }
	
	@GetMapping("/courseDescription")
    public List<Course> findByDescription(@RequestParam String description) {
        return courseService.getByDescription(description);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/courseTD")
//    public List<Course> findByTD(@RequestParam(name="title",required = false) String title, @RequestParam(name="description", required = false) String description) {
//        return courseService.getByTD(title, description);
//    }
	

}
