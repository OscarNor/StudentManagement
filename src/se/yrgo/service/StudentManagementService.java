package se.yrgo.service;

import java.util.List;
import javax.ejb.Local;
import se.yrgo.domain.Student;

@Local
public interface StudentManagementService {
	public void insertStudent(Student newStudent);
	public List<Student>findAllStudents();
	public List<Student>findStudentByLastName(String lastName);
	public Student findStudentById(int id);
}
