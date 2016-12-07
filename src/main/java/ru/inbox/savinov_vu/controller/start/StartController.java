package ru.inbox.savinov_vu.controller.start;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {


    @GetMapping("/")
    public String start(Model model) {
        return "start/start";
    }

    @GetMapping(value = "/editUser")
    public String editUser(Model model) {
        return "personal/admin";
    }


    @GetMapping(value = "/editOrder")
    public String editOrder(Model model) {
        return "goods/order";
    }

    @GetMapping(value = "/editLocal" )
    public String editLocal(Model model){
        return "local/local";
    }





}
