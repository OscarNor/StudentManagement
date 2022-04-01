package se.yrgo.rest;

import se.yrgo.domain.Student;
import se.yrgo.service.StudentManagementService;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Stateless
@Path("/students")
public class StudentResource {

    @Inject
    private StudentManagementService service;

    
    @GET
    @Produces("application/JSON")
    @Path("{studentNo}")
    public Student findStudentById(@PathParam("studentNo") int id) {
    	return service.findStudentById(id);
    }
    
	@GET
	@Produces("application/JSON")
    public List<Student> findAllStudents() {
        return service.findAllStudents();
    }
	
	
    
}
