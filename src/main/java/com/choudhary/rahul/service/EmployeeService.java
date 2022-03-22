package com.choudhary.rahul.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.choudhary.rahul.dao.EmployeeRepository;
import com.choudhary.rahul.entity.Employee;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	  public Employee addEmployee(Employee employee) {
	    return employeeRepository.save(employee);
	  }
	  
	  public List<Employee> getEmployees() {
	    return (List<Employee>) employeeRepository.findAll();
	  }
	  
	 public void updateEmployee(Employee employee, int id) 
	  {
		  Optional<Employee> optional=employeeRepository.findById(id);
		  if(optional.isPresent())
		  {
			  Employee e=optional.get();
			  e.setFirstName(employee.getFirstName());
			  e.setLastName(employee.getLastName());
			  e.setDesignation(employee.getDesignation());
			  e.setAge(employee.getAge());
			  employeeRepository.save(e);
		  }
	  }
	  
	  public void deleteEmployee(int id) {
	    employeeRepository.deleteById(id);
	  }
}
