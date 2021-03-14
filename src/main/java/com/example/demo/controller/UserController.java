package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	//VALIDADO
	@PostMapping
	public ResponseEntity<?> create (@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}
	
	//VALIDADO
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") int id){
		Optional <User> oUser=userService.findById(id);
		if(!oUser.isPresent()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User userdetails,@PathVariable(value="id") int userid){
		Optional<User> user=userService.findById(userid);
		if(!user.isPresent()){
			return ResponseEntity.notFound().build();
		}
		user.get().setName(userdetails.getName());
		user.get().setLast_name(userdetails.getLast_name());
		user.get().setHobbie(userdetails.getHobbie());
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
	}
	
	
	//VALIDADO
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value="id") int userid){
		if(!userService.findById(userid).isPresent()){
			return ResponseEntity.notFound().build();
		}
		userService.deleteById(userid);
		return ResponseEntity.ok().build();
	}
	
	
	//VALIDADO
	@GetMapping
	public List<User> readAll(){
		List<User> users=StreamSupport
				.stream(userService.findAll().spliterator(),false)
				.collect(Collectors.toList());
		return users;
	}
	
}
