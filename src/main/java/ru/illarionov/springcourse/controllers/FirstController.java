package ru.illarionov.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        String s = "Hello beach " + name + " " + surname;
        System.out.println(s);
        model.addAttribute("message", s);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "/first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {
        double res;
        switch (action) {
            case "multiplication":
                res = a * b;
                break;
            case "addition":
                res = a + b;
                break;
            case "subtraction":
                res = a - b;
                break;
            case "division":
                res = a / (double) b;
                break;
            default:
                res = 404500;
                        break;
        }

        model.addAttribute("res", res);
        return "first/calculator";
    }
}
