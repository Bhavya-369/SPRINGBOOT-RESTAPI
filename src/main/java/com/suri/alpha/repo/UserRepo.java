package com.suri.alpha.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.suri.alpha.dto.UserDTO;

@Repository
public class UserRepo {
	
	
	List<UserDTO> users = new ArrayList<>(Arrays.asList(
			
			new UserDTO("Suri", "9398298619"),
			new UserDTO("Ram", "7418529638"),
			new UserDTO("Hanuman", "9638527413"),
			new UserDTO("Krishna", "8529637415")
			));
	
	public List<UserDTO> getUsers() {
		return new ArrayList<>(users);
		
	}
	
	
	public void saveUsers(List<UserDTO> newUsers) {
		users.addAll(newUsers);
	}
	

}
