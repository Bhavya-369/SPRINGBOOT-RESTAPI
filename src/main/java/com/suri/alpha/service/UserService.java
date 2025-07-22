package com.suri.alpha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suri.alpha.dto.UserDTO;
import com.suri.alpha.exception.DuplicateUserException;
import com.suri.alpha.exception.ResourceNotFoundException;
import com.suri.alpha.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public List<UserDTO> getUsers() {
		return userRepo.getUsers();
	}

	public List<UserDTO> saveUsers(List<UserDTO> newUsers) {

		for (UserDTO newUser : newUsers) {

			boolean userExists = userRepo.getUsers().stream()
					.anyMatch(e -> e.getUserName().equalsIgnoreCase(newUser.getUserName())
							|| e.getMobile().equals(newUser.getMobile()));

			if (userExists) {
			    throw new DuplicateUserException("User with same name or mobile already present: " + newUser);
			}

		}
		userRepo.saveUsers(newUsers);

		return userRepo.getUsers();
	}



	public UserDTO getUserByNameOrEmail(String name, String mobile) throws ResourceNotFoundException {
		 if (name == null && mobile == null) {
	            throw new IllegalArgumentException("Either name or mobile must be provided");
	        }
		 
		
		 return userRepo.getUsers().stream()
		            .filter(user -> 
		                (name != null && user.getUserName().equalsIgnoreCase(name)) ||
		                (mobile != null && user.getMobile().equals(mobile))
		            )
		            .findFirst()
		            .orElseThrow(() -> {
		                String message;
		                if (name != null) {
		                    message = "User not found with name: " + name;
		                } else {
		                    message = "User not found with mobile: " + mobile;
		                }
		                return new ResourceNotFoundException(message);
		            });
	}
}
