package com.ers;

import com.ers.dao.EmployeeDao;
import com.ers.dao.EmployeeDaoFile;
import com.ers.dao.FileIO;
import com.ers.models.Employee;
import com.ers.services.EmployeeService;

public class ersDriver {
	
	public static void main(String args[]) {
		
		/*
		Employee emp1 = new Employee("Dennis","Few", "Dennis@mail.com", "password", false, 10.3);
	
		FileIO<Employee> employeeIO = new FileIO<Employee>("employee.txt");
	
		employeeIO.writeObject(emp1);
		
		System.out.println(employeeIO.readObject());
		
		*/
		//The easiest way to test before we have an api setup is through the driver
		
		EmployeeDao empDao	= new EmployeeDaoFile();
		EmployeeService empService = new EmployeeService(empDao);
		
		EmployeeController empController = new EmployeeController(empServ);
		
		//Setup our javalin app and routes
		Javalin app = Javalin.create(config -> {
			
		}
		)
		
		//empService.registerEmployee("Annie", "Few", "annie@mail.com", "password", false, 9);
		
		System.out.println(empService.login("annie@mail.com"));
		//empDao.addEmployee(new Employee("Annie", "Few", "annie@mail.com", "password", false, 9));
		
	}

}