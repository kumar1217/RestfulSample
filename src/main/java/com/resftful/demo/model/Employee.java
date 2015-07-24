package com.resftful.demo.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee")
public class Employee implements Serializable {
	
	
	private static final long serialVersionUID = 1893667834549900156L;
	
	private String employeeId;
	private String employeeName;
	private String employeeJob;

	public Employee(){
		//default Contructor
	}

	public Employee(String employeeId, String employeeName, String employeeJob) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeJob = employeeJob;
	}

	@XmlElement
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@XmlElement
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@XmlElement
	public String getEmployeeJob() {
		return employeeJob;
	}

	public void setEmployeeJob(String employeeJob) {
		this.employeeJob = employeeJob;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", employeeJob=" + employeeJob + "]";
	}

}
