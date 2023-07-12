package com.codewithsam.ums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithsam.ums.entity.User;
import com.codewithsam.ums.serviceImpl.ServiceImpl;

@RestController
@RequestMapping("/user")
public class Controller {

	@Autowired
	private ServiceImpl userService;

	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = null;

		try {
			users = userService.getAllUsers();

		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	@GetMapping("/{Id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer Id){
		User user = userService.getUserById(Id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	@PostMapping("/adduser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user2 = userService.addOrUpdateUser(user);
		return new ResponseEntity<User> (user2,HttpStatus.CREATED);
	}
	@DeleteMapping("/user/{Id}")
	public ResponseEntity<User> deleteUser(@PathVariable Integer Id) throws Exception{
		User user = userService.deleteUser(Id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
