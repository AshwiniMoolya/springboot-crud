package com.springrest.springboot.services;

import java.util.List;

import com.springrest.springboot.entity.Course;

public interface CourseServices {
	public List<Course> getCourses();
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);

	public void deleteCourse(long id);

	public List<Course> findCoursesWithSorting(String field);

	public Course getById(long courseId);

	public List<Course> getByTitle(String title);

	public List<Course> getByDescription(String description);

}
