package ru.inbox.savinov_vu.controller.start;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.inbox.savinov_vu.service.personal.UserService;

@Controller
public class StartController {

    @Qualifier("userService")
    @Autowired
    UserService service;

    @RequestMapping("/")
    public String start(Model model)  {
        return "start/start";
    }

    @GetMapping(value = "/editUser" )
    public String editUser(Model model)  {
        return "personal/admin";
    }


    @GetMapping(value = "/editOrder" )
    public String editOrder(Model model)  {
        return "goods/orderManage";
    }

    @GetMapping(value = "/addOrder" )
    public String OrderAdd(Model model) throws JsonProcessingException {

        return "goods/orderAdd";
    }

    @GetMapping(value = "editLocal" )
    public String editLocal(Model model){
        return "local/local";
    }


}
