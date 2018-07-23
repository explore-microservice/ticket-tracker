package com.issuetracker.webapp.dao;

import com.issuetracker.webapp.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


}
