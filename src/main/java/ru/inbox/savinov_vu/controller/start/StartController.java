package ru.inbox.savinov_vu.controller.start;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.inbox.savinov_vu.model.local.LocalStorage;

@Controller
public class StartController {

    // @Qualifier("userService")


    @RequestMapping("/")
    public String start(Model model)  {
        LocalStorage localStorage = new LocalStorage();
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




}
