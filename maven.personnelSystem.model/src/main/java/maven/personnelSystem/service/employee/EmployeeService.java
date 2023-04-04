package maven.personnelSystem.service.employee;

import java.util.List;

import maven.personnelSystem.model.employee.Employee;

public interface EmployeeService {

	boolean saveEmployee(Employee employee);

	boolean deleteEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	Employee findEmployeeById(Long employeeId);

	List<Employee> findAllEmployees();

}
