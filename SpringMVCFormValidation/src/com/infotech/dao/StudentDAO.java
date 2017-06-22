package com.infotech.dao;

import com.infotech.model.Student;

public interface StudentDAO {
	public abstract boolean saveStudent(Student student);
	public Student getStudentDetailsByEmailAndPassword(String email,String password);
}
