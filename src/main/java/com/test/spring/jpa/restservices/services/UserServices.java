package com.test.spring.jpa.restservices.services;

import com.test.spring.jpa.restservices.dao.UserRepository;
import com.test.spring.jpa.restservices.model.User;
import com.test.spring.jpa.restservices.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getAllUsers()
    {
        List<User> employeeList = userRepository.findAll();

        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<>();
        }
    }

    public User getUserById(Long id) throws ResourceNotFoundException
    {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            return user.get();
        } else {
            throw new ResourceNotFoundException("No user record exist for given id ","id",id);
        }
    }

    public User createOrUpdateUser(User user) throws ResourceNotFoundException
    {
        Optional<User> entity = userRepository.findById(user.getId());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if(entity.isPresent())
        {
            User newEntity = entity.get();
            newEntity.setName(user.getName());
            newEntity.setPassword(user.getPassword());
            newEntity.setRoles(user.getRoles());

            newEntity = userRepository.save(newEntity);

            return newEntity;
        } else {
            user = userRepository.save(user);

            return user;
        }
    }

    public String deleteById(Long id) throws ResourceNotFoundException
    {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent())
        {
            userRepository.deleteById(id);
            return "success";
        } else {
            throw new ResourceNotFoundException("No user record exist for given id ","id",id);
        }
    }


}
