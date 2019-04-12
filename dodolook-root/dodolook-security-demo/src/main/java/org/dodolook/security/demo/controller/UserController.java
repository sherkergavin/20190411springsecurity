package org.dodolook.security.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.dodolook.security.demo.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;



@RestController
public class UserController {

	@JsonView(User.UserDetilView.class)
	@GetMapping(value="/user",produces = {"application/json;charset=UTF-8"})
	public List<User> query(@RequestParam("username")String username,@RequestParam("age")String age,@RequestParam("password")String password){
		
		System.out.println("username:==>"+username);
		
		System.out.println("age:==>"+age);
		
		System.out.println("password:==>"+password);
		
		
		List<User> users = new ArrayList<>();
		
		users.add(new User("gavin","18","123456"));
		
		users.add(new User("sherker","20","654321"));
		
		users.add(new User("gwj","24","666666"));
		
		return  users;
	}
	
	@JsonView(User.UserSimpleView.class)
	@GetMapping(value="/u/{id}",produces = {"application/json;charset=UTF-8"})
	public User singleQuery(@PathVariable("id")String id){
		
		System.out.println("id:==>"+id);
			
		return  new User("gavin","18","123456");
	}
	
	
	@JsonView(User.UserSimpleView.class)
	@PostMapping(value="/user",produces = {"application/json;charset=UTF-8"})
	public User queryObj(@RequestBody User user){
		
		System.out.println(user.toString());
			
		return  new User("gavin","18","123456");
	}
	
	
}
