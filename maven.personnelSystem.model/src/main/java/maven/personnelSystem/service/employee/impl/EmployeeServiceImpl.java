package maven.personnelSystem.service.employee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maven.personnelSystem.dao.employee.EmployeeRepository;
import maven.personnelSystem.model.employee.Employee;
import maven.personnelSystem.service.employee.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public boolean saveEmployee(Employee employee) {
		return employeeRepository.saveEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		return employeeRepository.deleteEmployee(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.updateEmployee(employee);
	}

	@Override
	public Employee findEmployeeById(Long employeeId) {
		return employeeRepository.findEmployeeById(employeeId);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAllEmployees();
	}

}
