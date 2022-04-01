package se.yrgo.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import se.yrgo.domain.Student;

@Stateless
@Alternative
public class StudentDataAccessProdVersion implements StudentDataAccess {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void insertStudent(Student newStudent) {
		em.persist(newStudent);
	}

	@Override
	public Student findStudentById(int id) {
		TypedQuery<Student> tq1 = em.createQuery("select student from Student as student where student.id = :id", Student.class );
		tq1.setParameter("id", id);
		return tq1.getSingleResult();
	}

	@Override
	public List<Student> findAllStudents() {
//		TypedQuery<Student> tq2 = em.createQuery("select student from Student as student", Student.class);
//		return tq2.getResultList();
		Query tq2 = em.createQuery("select student from Student as student");
		List<Student> students = tq2.getResultList();
		return students;
	}

	@Override
	public List<Student> findStudentByLastName(String lastName) {
		TypedQuery<Student> tq3 = em.createQuery("select student from Student as student where student.lastName = :lastName", Student.class);
		tq3.setParameter("lastName", lastName);
		return tq3.getResultList();
	}
	
}