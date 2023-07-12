package com.codewithsam.ums.userRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codewithsam.ums.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

}
