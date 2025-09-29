package org.example.demo_session_and_cookie_int_spring.exercise.controller;

import org.example.demo_session_and_cookie_int_spring.exercise.model.CartEx;
import org.example.demo_session_and_cookie_int_spring.exercise.model.ProductEx;
import org.example.demo_session_and_cookie_int_spring.exercise.service.IProductExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/exercise/product")
public class ProductExController {
    @Autowired
    private IProductExService productService;

    @ModelAttribute("cart")
    public CartEx setupCart() {
        return new CartEx();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("exercise/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") long id,
                            @ModelAttribute("cart") CartEx cart,
                            @RequestParam("action") String action)
    {
        Optional<ProductEx> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "exercise/error_404";
        }
        if (action.equals("show")) {
            cart.addItem(productOptional.get());
            return "redirect:/exercise/product/shopping-cart";
        }
        cart.addItem(productOptional.get());
        return "redirect:/exercise/product/shop";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showProductDetail(@PathVariable("id") long id) {
        Optional<ProductEx> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ModelAndView("exercise/error_404");
        }
        ModelAndView modelAndView = new ModelAndView("exercise/detail");
        modelAndView.addObject("product", productOptional.get());
        return modelAndView;
    }
}
