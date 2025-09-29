package org.example.demo_session_and_cookie_int_spring.practice.p3.controller;

import org.example.demo_session_and_cookie_int_spring.practice.p3.model.Cart;
import org.example.demo_session_and_cookie_int_spring.practice.p3.model.Product;
import org.example.demo_session_and_cookie_int_spring.practice.p3.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/practice/p3/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("practice/p3/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") long id,
                            @ModelAttribute("cart") Cart cart,
                            @RequestParam("action") String action)
    {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "practice/p3/error_404";
        }
        if (action.equals("show")) {
            cart.addItem(productOptional.get());
            return "redirect:/practice/p3/product/shopping-cart";
        }
        cart.addItem(productOptional.get());
        return "redirect:/practice/p3/product/shop";
    }
}
