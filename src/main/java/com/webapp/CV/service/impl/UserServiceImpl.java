package com.webapp.CV.service.impl;

import com.webapp.CV.domain.User;
import com.webapp.CV.repository.TaskRepository;
import com.webapp.CV.repository.UserRepository;
import com.webapp.CV.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<User> getAll() {
       return userRepository.findAll();
    }

    @Override
    public List<User> findByRole(String role) {
        return null;
    }

    @Override
    public User findByName(String name){return userRepository.findByFullName(name);
    }

    @Override
    public void save(User user) {
    userRepository.save(user);

    }

    public void deleteAll(){
        userRepository.deleteAll();
    }
}
