package se.yrgo.rest;

import se.yrgo.domain.Student;
import se.yrgo.service.*;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Stateless
@Path("/students")
public class StudentResource {

    @Inject
    private StudentManagementService service;

    @GET
    @Produces("application/JSON")
    public List<Student> findAllStudents() {
        return service.findAllStudents();
    }
}
