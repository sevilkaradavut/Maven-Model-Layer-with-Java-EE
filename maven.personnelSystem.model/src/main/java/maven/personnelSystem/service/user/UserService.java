package maven.personnelSystem.service.user;

import java.util.List;

import maven.personnelSystem.model.user.User;
import maven.personnelSystem.web.dto.UserDto;

public interface UserService {

	User registerNewUser(UserDto userDto);

	boolean checkIfValidOldPassword(User user, String oldPassword);

	void changeUserPassword(User user, String password);

	User saveUser(User user);

	User updateUser(User user);

	User deleteUser(User user);

	User findUserById(Long id);

	User findUserByUsername(String username);

	User findUserByEmail(String email);

	List<User> findAllUsers();
}
