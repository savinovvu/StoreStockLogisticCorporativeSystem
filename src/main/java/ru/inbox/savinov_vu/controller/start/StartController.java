package ru.inbox.savinov_vu.controller.start;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.inbox.savinov_vu.service.UserService;

@Controller
public class StartController {

    @Qualifier("userService")
    @Autowired
    UserService service;

    @RequestMapping("/")
    public String start(Model model)  {


        return "start";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String editUser(Model model)  {


        return "admin";
    }


    @RequestMapping(value = "/editOrder", method = RequestMethod.GET)
    public String editOrder(Model model)  {


        return "orderManage";
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.GET)
    public String OrderAdd(Model model) throws JsonProcessingException {


        return "orderAdd";
    }


}
