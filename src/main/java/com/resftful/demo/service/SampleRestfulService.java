package com.resftful.demo.service;

/**
 * RestService class to handle rest request .
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.resftful.demo.model.Employee;

@Path(value = "/sampleService")
public class SampleRestfulService {

	private static Map<String, Employee> employees = new HashMap<String, Employee>();

	// Create static employee object to return back response for REST calls

	static {
		Employee employee_one = new Employee();
		employee_one.setEmployeeId("111");
		employee_one.setEmployeeName("ANDY");
		employee_one.setEmployeeJob("Make Candy");

		employees.put(employee_one.getEmployeeId(), employee_one);

		Employee employee_two = new Employee();
		employee_two.setEmployeeId("222");
		employee_two.setEmployeeName("SANDY");
		employee_two.setEmployeeJob("Make Brandy");

		employees.put(employee_two.getEmployeeId(), employee_two);
	}

	@GET
	@Path(value = "/hello")
	@Produces("text/plain")
	public String helloService() {
		return "Hello Restful World";
	}

	@GET
	@Path("/employees")
	@Produces("application/xml")
	public List<Employee> listEmployees() {
		return new ArrayList<Employee>(employees.values());
	}

	@GET
	@Path("/json/employees/")
	@Produces("application/json")
	public List<Employee> listEmployeesJSON() {
		return new ArrayList<Employee>(employees.values());
	}

	@GET
	@Path("/employee/{employeeid}")
	@Produces("application/xml")
	public Employee getEmployee(@PathParam("employeeid") String employeeId) {
		return employees.get(employeeId);
	}

	@GET
	@Path("/json/employee/{employeeid}")
	@Produces("application/json")
	public Employee getEmployeeJSON(@PathParam("employeeid") String employeeId) {
		return employees.get(employeeId);
	}

	@POST
	@Path("/postEmployee")
	public Response postEmployee(@FormParam("id") String id,
			@FormParam("name") String name, @FormParam("job") String job) {
		return Response
				.status(200)
				.entity(" Employee added successfuly!<br> Id: " + id
						+ "<br> Name: " + name + "<br> Job: " + job).build();
	}

	@POST
	@Path("/postJsonEmployeeResponse")
	@Produces("application/json")
	public Response postJsonEmployeeResponse(@FormParam("id") String id,
			@FormParam("name") String name, @FormParam("job") String job) {
		return Response
				.status(200)
				.entity(" Json Response Employee added successfuly!<br> Id: "
						+ id + "<br> Name: " + name + "<br> Job: " + job)
				.build();
	}

	@POST
	@Path("/postXMLEmployeeResponse")
	@Produces("application/xml")
	public Employee postXMLEmployeeResponse(@FormParam("id") String employeeId,
			@FormParam("name") String employeeName,
			@FormParam("job") String employeeJob) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setEmployeeJob(employeeJob);

		return employee;

	}

	@POST
	@Path("/postForConsumeJSONRequest")
	@Consumes("application/json")
	@Produces("application/json")
	public Employee postForConsumeJSONRequest(Employee employee) {
		Employee newEmployeeObject = new Employee(employee.getEmployeeId(),
				employee.getEmployeeName(), employee.getEmployeeJob());
		return newEmployeeObject;
	}

}
