package com.infotech.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.infotech.dao.StudentDAO;
import com.infotech.model.Student;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Override
	public boolean saveStudent(Student student) {
		int id = (Integer)hibernateTemplate.save(student);
		if(id>0)
			return true;
		return false;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Student getStudentDetailsByEmailAndPassword(String email,String password){
		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(Student.class);
		detachedCriteria.add(Restrictions.eq("email", email));
		detachedCriteria.add(Restrictions.eq("password", password));
		List<Student> findByCriteria = (List<Student>) hibernateTemplate.findByCriteria(detachedCriteria);
		if(findByCriteria !=null && findByCriteria.size()>0)
		return findByCriteria.get(0);
		else
			return null;
	}
}
