package com.learn.microservices.restfulservices.user;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;
	
	//GET Users
	@GetMapping("/users")
	public List<User> retriveAllUsers()
	{
		return userDaoService.findAll();
		
	}
	
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id)
	{
		 User user=userDaoService.findOne(id);
		 if(user==null)
		 {
			 throw new UserNotFoundException("id="+id);
		 }
		 
		//All users,SERVER_PATH+"/users"
			//retrieve all users
		//HATEOAS
		/*
		 * Resource<User> resource=new Resource<User>(user); ControllerLinkBuilder
		 * linkTo=linkTo(methodOn(this.getClass(), retriveAllUsers()));
		 * resource.add(linkTo.withRel("all-users"));
		 */
			return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity createUser(@Valid @RequestBody User user)
	{
		User savedUser=userDaoService.save(user);
	
	URI location=	ServletUriComponentsBuilder.
		fromCurrentRequest().
		path("{/id}").buildAndExpand(savedUser.getId()).toUri();
		
return ResponseEntity.created(location).build();
		}
	

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		 User user=userDaoService.deleteById(id);
		 if(user==null)
		 {
			 throw new UserNotFoundException("id="+id);
		 }
		
	}
	
	
	
	
}
