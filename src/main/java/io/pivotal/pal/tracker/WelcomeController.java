package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    String msg;

    @GetMapping("/")
    public String sayHello() {
        return "Hello from test";
    }

    public WelcomeController(@Value("${welcome.message}") String message){
        msg = message;
    }
}
