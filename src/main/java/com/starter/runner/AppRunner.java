package com.starter.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.starter.document.Employee;
import com.starter.repo.EmployeeRepository;

@Component
public class AppRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		repo.deleteAll();
		
		//1.insert one row
		Employee e = repo.save(new Employee(100, "ABC", 1.1));
		System.out.println(e.getEmpId());
		
		//2.Bulk insert
		List<Employee> list = repo.saveAll(Arrays.asList(new Employee(101,"CDE",2.2),
									new Employee(102, "FGH", 3.3),
									new Employee(103, "IJK", 4.4)));
		
		list.forEach(System.out::println);
		
	}

}
