package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;
@Repository
public interface StudentUtil extends JpaRepository<Student, Integer> {
	@Modifying
	@Query("update Student set name=?1 where id=?2")
	void updateName(String name,int id);
}
