package maven.personnelSystem.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import maven.personnelSystem.dao.user.UserRepository;
import maven.personnelSystem.exception.UserAlreadyExistException;
import maven.personnelSystem.model.user.User;
import maven.personnelSystem.service.user.UserService;
import maven.personnelSystem.web.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public User registerNewUser(UserDto userDto) {
		if (usernameExist(userDto.getUsername())) {
			throw new UserAlreadyExistException("Bu kullanıcı zaten kayıtlı. : " + userDto.getUsername());
		} else if (emailExist(userDto.getEmail())) {
			throw new UserAlreadyExistException("Bu kullanıcı e-postası zaten kayıtlı. : " + userDto.getEmail());
		}
		return null;
	}

	private boolean usernameExist(String username) {
		return findUserByUsername(username) != null;
	}

	private boolean emailExist(String email) {
		return findUserByEmail(email) != null;
	}

	@Override
	public boolean checkIfValidOldPassword(User user, String oldPassword) {
		return passwordEncoder.matches(oldPassword, user.getPassword());
	}

	@Override
	public void changeUserPassword(User user, String password) {
		/* Database e göndermek için değişen şifreyi */
		user.setPassword(passwordEncoder.encode(password));
		/* User güncellemesi */
		userRepository.updateUser(user);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.saveUser(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.updateUser(user);
	}

	@Override
	public User deleteUser(User user) {
		return userRepository.deleteUser(user);
	}

	@Override
	public User findUserById(Long id) {
		return userRepository.findUserById(id);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}

}
