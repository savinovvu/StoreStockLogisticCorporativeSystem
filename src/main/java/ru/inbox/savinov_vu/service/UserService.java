package ru.inbox.savinov_vu.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.inbox.savinov_vu.model.User;

public interface UserService {

   String getAllUsers() throws JsonProcessingException;
    String  getAllActiveUsers() throws JsonProcessingException;
    void addUser(User user);


 }
