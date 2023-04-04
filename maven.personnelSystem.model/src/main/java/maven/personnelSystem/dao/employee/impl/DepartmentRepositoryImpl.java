package maven.personnelSystem.dao.employee.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import maven.personnelSystem.dao.employee.DepartmentRepository;
import maven.personnelSystem.model.employee.Department;

@Repository
@Transactional
public class DepartmentRepositoryImpl implements DepartmentRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean saveDepartment(Department department) {
		entityManager.persist(department);
		return false;
	}

	@Override
	public boolean deleteDepartment(Department department) {

		if (entityManager.contains(department)) {
			entityManager.remove(department);
			return true;
		}

		Department deleteDepartment = findDepartmentById(department.getDepartmentId());
		entityManager.remove(deleteDepartment);
		return true;
	}

	@Override
	public Department updateDepartment(Department department) {

		Department updateDepartment = entityManager.merge(department);
		/* Tabloyu güncellemek için flush */
		entityManager.flush();
		return updateDepartment;
	}

	@Override
	@Transactional(readOnly = true)
	public Department findDepartmentById(Long departmentId) {
		TypedQuery<Department> typedQuery = entityManager
				.createNamedQuery("Department.findLocationAndEmployeesByDepartmentId", Department.class);
		typedQuery.setParameter("departmentId", departmentId);
		return typedQuery.getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Department> findAllDepartments() {
		TypedQuery<Department> typedQuery = entityManager.createNamedQuery("Department.findAll", Department.class);
		return typedQuery.getResultList();
	}

	@Override
	public List<String> findDepartmentNames() {
		TypedQuery<String> typedQuery = entityManager.createNamedQuery("Department.findByDepartmentName", String.class);
		return typedQuery.getResultList();
	}

}
