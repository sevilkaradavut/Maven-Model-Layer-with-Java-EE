package maven.personnelSystem.dao.employee;

import java.util.List;

import maven.personnelSystem.model.employee.Department;

public interface DepartmentRepository {

	boolean saveDepartment(Department department);

	boolean deleteDepartment(Department department);

	Department updateDepartment(Department department);

	Department findDepartmentById(Long departmentId);

	List<Department> findAllDepartments();

	List<String> findDepartmentNames();
}
