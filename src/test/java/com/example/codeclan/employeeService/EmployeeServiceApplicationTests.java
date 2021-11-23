package com.example.codeclan.employeeService;

import com.example.codeclan.employeeService.models.Department;
import com.example.codeclan.employeeService.models.Employee;
import com.example.codeclan.employeeService.models.Project;
import com.example.codeclan.employeeService.repositories.DepartmentRepository;
import com.example.codeclan.employeeService.repositories.EmployeeRepository;
import com.example.codeclan.employeeService.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeServiceApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateEmployee(){
		Department department = new Department("IT");
		departmentRepository.save(department);
		Employee employee = new Employee("Andrew", 29, 153333, "admin@AS-Brown.com", department);
		employeeRepository.save(employee);
		Project project1 = new Project("Project1", 10);
		projectRepository.save(project1);

		project1.addEmployee(employee);
		projectRepository.save(project1);
	}
}
