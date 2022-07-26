
package com.kgpco.secure.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kgpco.secure.demo.dto.Contact;
import com.kgpco.secure.demo.model.Employee;
import com.kgpco.secure.demo.model.EmployeeRepo;
import com.kgpco.secure.demo.services.SampleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

	@Autowired
	private SampleService sampleService;

	@Autowired
	private EmployeeRepo repo;

	@GetMapping(value = "/details", produces = { "application/xml" })
	@PreAuthorize("hasRole('ROLE_kgpcodemo')") // This is validating against user
	@ResponseStatus(HttpStatus.OK)
	public Contact getContactDetails() {
		return sampleService.printDetails();
	}

	@GetMapping(value = "/employees", produces = { "application/xml" })
	@PreAuthorize("hasRole('ROLE_kgpcodemo')") // This is validating against user
	public List<Employee> getEmployees() {
		return repo.findAll();
	}

	@PostMapping(value = "/employee", consumes = { "application/xml" })
	public Employee addEmployee(@RequestBody Employee employee) {
		return repo.save(employee);
	}

	@GetMapping("/data")
	public String getDetails() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("my-beans.xml");

		SimpleDriverDataSource dataSource = (SimpleDriverDataSource) ctx.getBean("dataSource");

		String detil = "Url: {}" + dataSource.getUrl() + " User name: {}" + dataSource.getUsername() + " Password: {}"
				+ dataSource.getPassword();

		logger.info("Url: {}", dataSource.getUrl());
		logger.info("User name: {}", dataSource.getUsername());
		logger.info(" Password: {}" + dataSource.getPassword());

		return detil;
	}

}
