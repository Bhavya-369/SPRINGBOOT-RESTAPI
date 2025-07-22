package com.suri.alpha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suri.alpha.dto.UserDTO;
import com.suri.alpha.exception.ResourceNotFoundException;
import com.suri.alpha.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class AlphaController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<String> createUsers(@Valid @RequestBody List<UserDTO> dtoList) {
	    List<UserDTO> users = userService.saveUsers(dtoList);
	    return new ResponseEntity<>("User saved", HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getUsers() {
	    List<UserDTO> users = userService.getUsers();
	    return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<UserDTO> getUserByNameOrMobile(
	        @RequestParam(required = false) String name,
	        @RequestParam(required = false) String mobile) throws ResourceNotFoundException {

	    UserDTO user = userService.getUserByNameOrEmail(name, mobile);
	    return ResponseEntity.ok(user);
	}
}
