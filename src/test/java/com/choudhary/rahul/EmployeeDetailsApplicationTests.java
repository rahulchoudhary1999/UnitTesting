package com.choudhary.rahul;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.skyscreamer.jsonassert.JSONAssert;
import java.util.LinkedList;
import java.util.List;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.choudhary.rahul.controller.EmployeeController;
import com.choudhary.rahul.entity.Employee;
import com.choudhary.rahul.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@SpringBootTest
//@RunWith(SpringRunner.class)
@WebMvcTest(value =EmployeeController.class)

class EmployeeDetailsApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService employeeService;

	
	@Test
	public void testGetEmployee() throws Exception {
		List<Employee> employees=new LinkedList<>();
		when(employeeService.getEmployees()).thenReturn(employees);
		
		MockHttpServletRequestBuilder reqBuilder=MockMvcRequestBuilders.get("/employee/getEmployees").accept(MediaType.APPLICATION_JSON);
		ResultActions perform=mockMvc.perform(reqBuilder);
		
		MvcResult mvcResult=perform.andReturn();
		
		MockHttpServletResponse response=mvcResult.getResponse();
		
		int status=response.getStatus();
		System.out.println("Status is:"+status);
		assertEquals(200,status);
	}
	
	@Test
	public void testAddEmployee() throws Exception {
		Employee employee=new Employee();
		
		when(employeeService.addEmployee(Mockito.any(Employee.class))).thenReturn(employee);
		
		ObjectMapper mapper=new ObjectMapper();
		String employeeJson=mapper.writeValueAsString(employee);
		
		MockHttpServletRequestBuilder reqBuilder=MockMvcRequestBuilders.post("/employee/addEmployee")
				.contentType(MediaType.APPLICATION_JSON)
				.content(employeeJson);
		
		
		ResultActions perform=mockMvc.perform(reqBuilder);
		
		MvcResult andReturn=perform.andReturn();
		
		MockHttpServletResponse response=andReturn.getResponse();
		
		int status=response.getStatus();
		
		assertEquals(200,status);
		
	}
	
	@Test
	public void testUpdateEmployee() throws Exception{

		
		//when(employeeService.updateEmployee(Mockito.any(Employee.class),Mockito.anyInt())).thenReturn();
		
		//if return type of method is void then what should we specify to thenReturn() method
	}
	
	

}
