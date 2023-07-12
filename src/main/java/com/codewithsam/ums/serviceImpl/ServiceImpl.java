package com.codewithsam.ums.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithsam.ums.entity.User;
import com.codewithsam.ums.userRepository.UserRepo;
import com.codewithsam.ums.userService.UserService;

@Service
public class ServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public User getUserById(int userId) {
		return userRepo.findById(userId).orElse(null);
	}

	@Override
	public User addOrUpdateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User deleteUser(int userId) throws Exception {
		User deleteUser = null;

		try {
			deleteUser = userRepo.findById(userId).orElse(null);

			if (deleteUser == null) {
				throw new Exception("user not available");
			} else {
				userRepo.deleteById(userId);
			}

		} catch (Exception e) {
			throw e;
		}

		return deleteUser;
	}

}
