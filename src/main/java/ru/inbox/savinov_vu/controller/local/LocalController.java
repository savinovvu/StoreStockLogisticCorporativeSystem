package ru.inbox.savinov_vu.controller.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.inbox.savinov_vu.service.local.LocalService;

@Controller
public class LocalController {

    @Autowired
    LocalService localService;

    @GetMapping(value = "editLocal" )
    public String editLocal(Model model){
        model.addAttribute("locals", localService.getAllLocal());
        return "local/local";
    }

    @GetMapping(value = "deleteLocal")
    public String deleteLocal(Model model){
        System.out.println("в методев методев методев методе");
        System.out.println("в методев методев методев методе");
        System.out.println("в методев методев методев методе");
        System.out.println("в методев методев методев методе");
        System.out.println("в методев методев методев методе");
        System.out.println("в методев методев методев методе");
        return "local/local";
    }

}
