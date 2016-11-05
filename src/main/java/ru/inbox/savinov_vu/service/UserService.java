package ru.inbox.savinov_vu.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserService {
  String getAllUsers() throws JsonProcessingException;

 }
