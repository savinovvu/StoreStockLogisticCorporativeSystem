package ru.inbox.savinov_vu.controller.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.personal.User;
import ru.inbox.savinov_vu.service.personal.UserService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Qualifier("userService")
    @Autowired
    UserService service;



    @GetMapping(value = "/all")
    public List<User> getAllUsers(Model model) throws JsonProcessingException {
        return service.getAllUsers();

    }



    @GetMapping
    public List<User> getAllActiveUsers(Model model) throws JsonProcessingException {
        return service.getAllActiveUsers();

    }



    @PutMapping
    public List<User> putUser(Model model, @RequestBody User user) throws IOException {
        System.out.println(user);
        System.out.println(user);
        System.out.println(user);
        System.out.println(user);
        service.addUser(user);
        return service.getAllActiveUsers();

    }



    @PostMapping
    public List<User> changeActiveUser(Model model, @RequestBody User user) throws IOException {
        service.addUser(user);
        return service.getAllUsers();
    }

}
