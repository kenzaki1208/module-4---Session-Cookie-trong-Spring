package org.example.demo_session_and_cookie_int_spring.practice.p3.controller;

import org.example.demo_session_and_cookie_int_spring.practice.p3.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/practice/p3/product")
public class ShoppingController {
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("practice/p3/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }
}
