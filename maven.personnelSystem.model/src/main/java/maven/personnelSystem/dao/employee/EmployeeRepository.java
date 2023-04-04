package maven.personnelSystem.dao.employee;

import java.util.List;

import maven.personnelSystem.model.employee.Employee;

public interface EmployeeRepository {

	boolean saveEmployee(Employee employee);

	boolean deleteEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	Employee findEmployeeById(Long employeeId);

	List<Employee> findAllEmployees();

}
