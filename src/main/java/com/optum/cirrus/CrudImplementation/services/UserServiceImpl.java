package com.optum.cirrus.CrudImplementation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optum.cirrus.CrudImplementation.model.User;
import com.optum.cirrus.CrudImplementation.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;



    @Override
    public void save(User user) {
        user.setPassword(user.getPassword());
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
