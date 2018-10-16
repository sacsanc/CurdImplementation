package com.optum.cirrus.CrudImplementation.services;

import com.optum.cirrus.CrudImplementation.model.User;

public interface UserService {

	 void save(User user);

	    User findByUsername(String username);
}
