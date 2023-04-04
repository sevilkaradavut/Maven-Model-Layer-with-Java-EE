package maven.personnelSystem.dao.employee.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import maven.personnelSystem.dao.employee.EmployeeRepository;
import maven.personnelSystem.model.employee.Employee;

@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean saveEmployee(Employee employee) {
		entityManager.persist(employee);
		return true;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		if (entityManager.contains(employee)) {
			entityManager.remove(employee);
			return true;
		}
		Employee deleteEmploye = findEmployeeById(employee.getEmployeeId());
		entityManager.remove(deleteEmploye);
		return true;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee updateEmployee = entityManager.merge(employee);
		entityManager.flush();
		return updateEmployee;
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findEmployeeById(Long employeeId) {
		TypedQuery<Employee> typedQuery = entityManager.createNamedQuery("Employee.findFullById", Employee.class);
		typedQuery.setParameter("employeeId", employeeId);
		return typedQuery.getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAllEmployees() {
		TypedQuery<Employee> typedQuery = entityManager.createNamedQuery("Employee.findAll", Employee.class);
		return typedQuery.getResultList();
	}

}
