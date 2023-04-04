package maven.personnelSystem.service.user;

import java.util.List;

import maven.personnelSystem.model.user.Privilege;

public interface PrivilegeService {
	Privilege savePrivilege(Privilege privilege);

	Privilege updatePrivilege(Privilege privilege);

	Privilege deletePrivilege(Privilege privilege);

	Privilege findPrivilegeById(Long id);

	Privilege findPrivilegeByName(String privilegeName);

	List<Privilege> findAllPrivileges();
}
