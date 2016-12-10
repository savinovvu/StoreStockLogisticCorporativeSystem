package ru.inbox.savinov_vu.controller.start;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.inbox.savinov_vu.model.personal.Role;
import ru.inbox.savinov_vu.model.personal.User;
import ru.inbox.savinov_vu.service.personal.UserService;

import java.util.Locale;
import java.util.ResourceBundle;

@Controller
public class StartController {


    @Qualifier("userService")
    @Autowired
    UserService service;
    private static User startedUser;


    @GetMapping("/")
    public String start(Model model) {

        if (startedUser == null) {
            startedUser = getUser.user;
            service.addUser(startedUser);
        }


        return "start/start";
    }

    @GetMapping(value = "/editUser")
    public String editUser(Model model) {
        return "personal/admin";
    }


    @GetMapping(value = "/editOrder")
    public String editOrder(Model model) {
        return "goods/index";
    }

    @GetMapping(value = "/editLocal")
    public String editLocal(Model model) {
        return "local/local";
    }


    private static class getUser {
        private static final Locale locale = Locale.ENGLISH;
        private static final ResourceBundle bundle = ResourceBundle.getBundle("settings/user", locale);
        private static final User user = new User(Integer.valueOf(bundle.getString("pin")), "Руководитель", Role.Руководитель, true);
    }


}
