package maven.personnelSystem.dao.user;

import java.util.List;

import maven.personnelSystem.model.user.User;

public interface UserRepository {

	User saveUser(User user);

	User updateUser(User user);

	User deleteUser(User user);

	User findUserById(Long id);

	User findUserByUsername(String username);

	User findUserByEmail(String email);

	List<User> findAllUsers();

}
