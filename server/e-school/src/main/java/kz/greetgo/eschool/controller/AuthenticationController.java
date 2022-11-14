package kz.greetgo.eschool.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthenticationController {
    @GetMapping("/")
    public String login(){
        return "You have successfully logged in!";
    }
    @GetMapping("/logout/success")
    public String logout(){
        return "You have successfully logged out!";
    }
}
