package ru.inbox.savinov_vu.controller.start;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.inbox.savinov_vu.model.local.LocalStorage;
import ru.inbox.savinov_vu.service.local.LocalService;

@Controller
public class StartController {

    // @Qualifier("userService")
    @Autowired
    LocalService localService;

    @RequestMapping("/")
    public String start(Model model)  {
        LocalStorage localStorage = new LocalStorage();
        localStorage.setLocalName("стораж");
        System.out.println("Startметод");
        System.out.println("Startметод");
        System.out.println("Startметод");
        System.out.println("Startметод");
        System.out.println("Startметод");
        System.out.println("Startметод");
        System.out.println("Startметод");
        System.out.println("Startметод");
        localService.addLocal(localStorage);
        System.out.println("добавили");
        localService.getAllLocal().forEach(System.out::println);
        System.out.println("updatile");
        localStorage.setLocalId(1);
        localStorage.setLocalName("стораж2 new");
        localService.updateLocal(localStorage);
        localService.getAllLocal().forEach(System.out::println);
        System.out.println("удалили");
        localService.deleteLocal(localStorage);
        localService.getAllLocal().forEach(System.out::println);
        System.out.println("удалено");


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
