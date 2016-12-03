package ru.inbox.savinov_vu.controller.local;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.local.LocalStorage;
import ru.inbox.savinov_vu.service.local.LocalService;

import java.util.List;

@RestController
@RequestMapping(value = "/locals", produces = MediaType.APPLICATION_JSON_VALUE)
public class LocalController {

    @Autowired
    LocalService service;



    @GetMapping(value = "/all")
    public List<LocalStorage> getAllLocal(Model model) throws JsonProcessingException {
            return service.getAllLocal();
    }



    @PutMapping
    public List<LocalStorage> putLocal(Model model, @RequestBody LocalStorage localStorage) throws JsonProcessingException {
        service.addLocal(localStorage);
        return service.getAllLocal();
    }


    @DeleteMapping
    public List<LocalStorage> deleteLocal(Model model, @RequestBody LocalStorage localStorage){
        service.deleteLocal(localStorage.getId());
        return service.getAllLocal();
    }




}
