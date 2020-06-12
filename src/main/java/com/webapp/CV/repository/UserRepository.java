package com.webapp.CV.repository;


import com.webapp.CV.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
 User findByFullName(String fullName);

}
