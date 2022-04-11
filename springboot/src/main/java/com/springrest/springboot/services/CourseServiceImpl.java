package com.springrest.springboot.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springrest.springboot.dao.CourseDao;
import com.springrest.springboot.entity.Course;

@Service
public class CourseServiceImpl implements CourseServices {
    Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
	}

	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long id) {
		courseDao.deleteById(id);
	}

	@Override
	public List<Course> findCoursesWithSorting(String field) {
        return  courseDao.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	@Override
	public Course getById(long courseId) {
		try {
		 return courseDao.findById(courseId).orElse(null);
		} catch(Exception e) {
			System.out.println("Exception: "+e.getLocalizedMessage());
		}
		return null;
	}

	@Override
	public List<Course> getByTitle(String title) {
        return courseDao.findByTitle(title);
    }

	@Override
	public List<Course> getByDescription(String description) {
		 return courseDao.findByDescription(description);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public List<Course> getByTD(String title, String description) {
//		return courseDao.findByTD(title, description);
//	}

	

}
