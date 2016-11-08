package ru.inbox.savinov_vu.controller.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.User;
import ru.inbox.savinov_vu.service.UserService;

import java.io.IOException;

@Controller
public class UserController {

    @Qualifier("userService")
    @Autowired
    UserService service;

    @Autowired
    ObjectMapper mapper;


    @ResponseBody
    @RequestMapping(value = "/xxx", method = RequestMethod.GET)
    public String getAll(Model model)  {


        return "русский текст";

    }


    @ResponseBody
    @RequestMapping(value = "/AllUsers", method = RequestMethod.GET)
    public String getAllUsers(Model model) throws JsonProcessingException {

        System.out.println(service.getAllUsers());


        return service.getAllUsers();

    }


    @ResponseBody
    @RequestMapping(value = "/AllActiveUsers", method = RequestMethod.GET)
    public String getAllActiveUsers(Model model) throws JsonProcessingException {


        return service.getAllActiveUsers();

    }


    @ResponseBody
    @RequestMapping(value = "/putUser", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public String putUser(Model model, @RequestBody String json) throws IOException {
        System.out.println("json1");
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");
        System.out.println(json);
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");
        User user = mapper.readValue(json, User.class);

        service.addUser(user);

        return service.getAllActiveUsers();

    }


    @ResponseBody
    @RequestMapping(value = "/changeActiveUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String changeActiveUser(Model model, @RequestBody String json) throws IOException {
        System.out.println("json2");
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");
        System.out.println(json);
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");
        System.out.println("json");

        User user = mapper.readValue(json, User.class);
        service.addUser(user);

        return service.getAllActiveUsers();

    }

}
