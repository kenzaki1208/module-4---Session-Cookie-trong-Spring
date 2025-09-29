package org.example.demo_session_and_cookie_int_spring.exercise.controller;

import org.example.demo_session_and_cookie_int_spring.exercise.model.CartEx;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exercise/product")
public class ShoppingExController {
    @ModelAttribute("cart")
    public CartEx setupCart() {
        return new CartEx();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") CartEx cart) {
        ModelAndView modelAndView = new ModelAndView("exercise/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @GetMapping("/remove/{id}")
    public String removeItem(@PathVariable("id") Long id, @SessionAttribute("cart") CartEx cart) {
        cart.getProducts().entrySet().removeIf(entry -> entry.getKey().getId() == id);
        return "redirect:/exercise/product/shopping-cart";
    }

    @PostMapping("/update")
    public String updateItem(@RequestParam("id") Long id, @RequestParam("quantity") int quantity,
                             @SessionAttribute("cart") CartEx cart) {
        cart.getProducts().entrySet().forEach(entry -> {
            if (entry.getKey().getId() == id) {
                cart.updateItem(entry.getKey(), quantity);
            }
        });
        return "redirect:/exercise/product/shopping-cart";
    }

    @GetMapping("/checkout")
    public ModelAndView checkout(@SessionAttribute("cart") CartEx cart) {
        ModelAndView modelAndView = new ModelAndView("exercise/checkout");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @PostMapping("/checkout")
    public String processCheckout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "exercise/success";
    }
}
