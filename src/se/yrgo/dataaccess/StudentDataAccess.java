package se.yrgo.dataaccess;

import java.util.List;
import javax.ejb.Local;
import se.yrgo.domain.Student;

@Local
public interface StudentDataAccess {
	
	public void insertStudent(Student newStudent);
	public Student findStudentById(int id);
	public List<Student> findAllStudents();
	public List<Student> findStudentByLastName(String lastName);
}
