package ru.inbox.savinov_vu.service.personal;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.personal.User;
import ru.inbox.savinov_vu.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public List<User> getAllUsers() throws JsonProcessingException {
        return repository.findAll();
    }

    @Override
    public List<User> getAllActiveUsers() throws JsonProcessingException {
        return repository.getAllActiveUser();
    }
    @Override
    public void addUser(User user) {
        if(String.valueOf(user.getId()).length() == 4) {
            repository.saveAndFlush(user);
        }
    }
}
