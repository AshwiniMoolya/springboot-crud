package com.springrest.springboot.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springrest.springboot.entity.Course;

public interface CourseDao extends JpaRepository<Course, Long>{
	
	@Query("SELECT c FROM Course c WHERE CONCAT(c.title, c.description) LIKE %?1%")
	List<Course> findByTitle(String title);
	
	@Query("SELECT c FROM Course c WHERE CONCAT(c.title, c.description) LIKE %?1%")
	List<Course> findByDescription(String description);
}

