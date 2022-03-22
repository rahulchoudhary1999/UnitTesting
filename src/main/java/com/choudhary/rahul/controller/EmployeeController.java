package com.choudhary.rahul.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.choudhary.rahul.dao.EmployeeRepository;
import com.choudhary.rahul.entity.Employee;
import com.choudhary.rahul.service.EmployeeService;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
    private EmployeeService employeeService;
	
	  @PostMapping("/addEmployee")
	  public Employee addEmployee(@RequestBody Employee employee) {
	    return employeeService.addEmployee(employee);
	  }
	  
	  @GetMapping("/getEmployees")
	  public List<Employee> getEmployees() {
	    return employeeService.getEmployees();
	  }
	  
	  @PutMapping("/updateEmployee/{id}")
	 public void updateEmployee(@RequestBody Employee employee, @PathVariable int id) 
	  {
		  employeeService.updateEmployee(employee, id);
	  }
	  
	  @DeleteMapping("/deleteEmployee/{id}")
	  void deleteEmployee(@PathVariable int id) {
	    employeeService.deleteEmployee(id);
	  }
}
