package com.vicketrossing.springbootproject.service;


import com.vicketrossing.springbootproject.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void save(User theUser);

}
