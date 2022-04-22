package com.example.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.transformation.UserTransformation;
import com.example.demo.entity.User;
import com.example.demo.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Component
@Transactional
public class UserService {

    private @Autowired
    UserRepository repository;

    public UserDTO getByUserName(String username) {
        User user = repository.findByUsername(username);
        return UserTransformation.fromEntity(user);
    }
    
	public UserDTO getById(String id) {
		 User user = repository.getById(id);
	        return UserTransformation.fromEntity(user);
	}

    public UserDTO createUser(UserDTO userDTO) {

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        repository.save(user);

        return userDTO;
    }
    
    public UserDTO updateUser(UserDTO userDTO) {
    	String username = userDTO.getUsername();
    	User user = repository.findByUsername(username);
        
    	 user.setFirstName(userDTO.getFirstName());
         user.setLastName(userDTO.getLastName());
         user.setPassword(userDTO.getPassword());
         
             repository.save(user);
       
          return userDTO;
    }
    
    public String deleteUser(String id) {
   	 User user = repository.getById(id);
           repository.delete(user);
           return "deleted";
   }

}

