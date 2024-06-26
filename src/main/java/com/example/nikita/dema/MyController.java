package com.example.nikita.dema;

import com.example.nikita.dema.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
public class MyController {

    @Autowired
    private MyService myService;
    @GetMapping("/my-get")
    public String getString(){
        return myService.getString();
    }
}
