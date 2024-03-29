package com.lifelinepathlab.user_sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lifelinepathlab.exception.ResourceNotFoundException;
import com.lifelinepathlab.model.User;
import com.lifelinepathlab.user_repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepositoryRef;
	
	public User addUser(User user) {
		User newUser = userRepositoryRef.save(user);
		return newUser;
	}
	
	public List<User> getUsers() {
		List<User> users = userRepositoryRef.findAll();
		return users;
	}
	
	public User getUser(int userId) {
		User user = userRepositoryRef.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User does not exits with User Id: ", userId));
		return user;	
	}
		
	public User updateUser(User newUser, int userId) {
		User oldUser = userRepositoryRef.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User does not exits with User Id: ", userId));
			oldUser.setFirstName(newUser.getFirstName());
			oldUser.setLastName(newUser.getLastName());
			oldUser.setEmailId(newUser.getEmailId());
			oldUser.setContactNo(newUser.getContactNo());
			oldUser.setDateOfBirth(newUser.getDateOfBirth());
			oldUser.setGender(newUser.getGender());
			oldUser.setBloodGroup(newUser.getBloodGroup());
			oldUser.setAddress(newUser.getAddress());
			oldUser.setPassword(newUser.getPassword());			
			oldUser.setConfirmPassword(newUser.getConfirmPassword());
			userRepositoryRef.save(oldUser);
			
			return oldUser;
	}
	
	public void deleteUser(int userId) {
		User user = userRepositoryRef.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User does not exits with User Id: ", userId));
		userRepositoryRef.delete(user);
	}

}
