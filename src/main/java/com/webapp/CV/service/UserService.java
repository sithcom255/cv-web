package com.webapp.CV.service;



import com.webapp.CV.domain.User;

import java.util.List;

public interface UserService {
     Iterable<User> getAll();

     List<User> findByRole(String role);

     User findByName(String name);

     void save(User user);

     void deleteAll();
}
