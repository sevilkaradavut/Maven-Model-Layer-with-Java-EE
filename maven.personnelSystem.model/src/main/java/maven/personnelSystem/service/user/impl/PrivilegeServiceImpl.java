package maven.personnelSystem.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maven.personnelSystem.dao.user.PrivilegeRepository;
import maven.personnelSystem.model.user.Privilege;
import maven.personnelSystem.service.user.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Override
	public Privilege savePrivilege(Privilege privilege) {
		return privilegeRepository.savePrivilege(privilege);
	}

	@Override
	public Privilege updatePrivilege(Privilege privilege) {
		return privilegeRepository.updatePrivilege(privilege);
	}

	@Override
	public Privilege deletePrivilege(Privilege privilege) {
		return privilegeRepository.deletePrivilege(privilege);
	}

	@Override
	public Privilege findPrivilegeById(Long id) {
		return privilegeRepository.findPrivilegeById(id);
	}

	@Override
	public Privilege findPrivilegeByName(String privilegeName) {
		return privilegeRepository.findPrivilegeByName(privilegeName);
	}

	@Override
	public List<Privilege> findAllPrivileges() {
		return privilegeRepository.findAllPrivileges();
	}

}
