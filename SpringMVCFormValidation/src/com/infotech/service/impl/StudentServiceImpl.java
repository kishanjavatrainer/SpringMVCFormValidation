package com.infotech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.dao.StudentDAO;
import com.infotech.model.Student;
import com.infotech.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	
	@Override
	public boolean registerStudent(Student student) {
		boolean isRegister=false;
		boolean saveStudent = getStudentDAO().saveStudent(student);
		if(saveStudent)
			isRegister=true;
		return isRegister;
	}

	@Override
	public Student validateStudentCredential(String email, String password) {
		Student student = getStudentDAO().getStudentDetailsByEmailAndPassword(email, password);
		return student;
	}
}
