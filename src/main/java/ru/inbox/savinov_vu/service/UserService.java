package ru.inbox.savinov_vu.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.inbox.savinov_vu.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers() throws JsonProcessingException;
    List<User>  getAllActiveUsers() throws JsonProcessingException;
    void addUser(User user);


 }
