package org.example.demo_session_and_cookie_int_spring.practice.p1.controller;

import org.example.demo_session_and_cookie_int_spring.practice.p1.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("counter")
@RequestMapping("/practice/p1/counter")
public class CounterController {
    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }

    @GetMapping("/")
    public String get(@ModelAttribute("counter") Counter counter) {
        counter.increment();
        return "practice/p1/index";
    }
}
