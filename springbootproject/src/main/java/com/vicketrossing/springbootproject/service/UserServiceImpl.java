package com.vicketrossing.springbootproject.service;

import com.vicketrossing.springbootproject.entity.User;
import com.vicketrossing.springbootproject.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }
}
