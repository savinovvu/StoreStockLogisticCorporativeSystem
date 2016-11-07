package ru.inbox.savinov_vu.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.User;
import ru.inbox.savinov_vu.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    ObjectMapper mapper;



    @Override
    public String getAllUsers() throws JsonProcessingException {

        return mapper.writeValueAsString(repository.findAll());
    }

    @Override
    public String getAllActiveUsers() throws JsonProcessingException {

        return mapper.writeValueAsString(repository.getAllActiveUser());
    }

    @Override
    public void addUser(User user) {

        repository.saveAndFlush(user);

    }
}
