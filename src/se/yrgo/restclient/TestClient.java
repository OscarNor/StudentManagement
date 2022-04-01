package se.yrgo.restclient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class TestClient {
	public static void main(String[] args) {
		
		//GET
//		Client client = ClientBuilder.newClient();
//		Response response = 
//				client.target("http://localhost:8080/StudentDb/webservice/student").request().buildGet().invoke();
//		 List<Student> students = response.readEntity(new 
//                 GenericType<List<Student>>() {});
//
//		 for (Student s : students) {
//				System.out.println(s);
//			}
//		 
//
//		 response.close();
		
		//POST
		Client client = ClientBuilder.newClient();
		Student Pelle = new Student();
			Pelle.setFirstName("Pelle");
			Pelle.setLastName("Svanslös");
			Pelle.setSchool("Hosta hårboll yrkeshöskola");
			Pelle.setAdmissionYear("2003");
		 
			Entity benEntity = Entity.entity(Pelle, "application/JSON");
			
			Response response = client.target("http://localhost:8080/StudentDb/webservice/student").request().buildPost(benEntity).invoke();
			System.out.println(response.readEntity(Student.class).getId());
			response.close();
			
			response = client.target("http://localhost:8080/StudentDb/webservice/student").request().buildGet().invoke();
			List<Student> students = response.readEntity(new 
             GenericType<List<Student>>() {});

			for (Student s : students) {
				System.out.println(s);
			}
	 

			response.close();
	}
}
