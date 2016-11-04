package ru.inbox.savinov_vu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.inbox.savinov_vu.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;


    @Override
    public boolean getAllUsers() {
           repository.findAll().forEach(System.out::println);
        return false;
    }
}
