package com.vicketrossing.springbootproject.controller;

import com.vicketrossing.springbootproject.entity.Cart;
import com.vicketrossing.springbootproject.entity.Product;
import com.vicketrossing.springbootproject.entity.User;
import com.vicketrossing.springbootproject.service.CartService;
import com.vicketrossing.springbootproject.service.OrderService;
import com.vicketrossing.springbootproject.service.ProductService;
import com.vicketrossing.springbootproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/store")
public class ProductController {

    private final ProductService productService;
    private final OrderService orderService;
    private final UserService userService;
    private final CartService cartService;

    public ProductController(ProductService productService, OrderService orderService, UserService userService, CartService cartService) {
        this.productService = productService;
        this.orderService = orderService;
        this.userService = userService;
        this.cartService = cartService;
    }





    @GetMapping("/list")
    public String listPhones(Model theModel){

        List<Product> theProduct = productService.findAll();

        System.out.println(theProduct);

        theModel.addAttribute("phones", theProduct);


        return "store/frontpage";
    }




    @GetMapping("/total")
    public String totalPrice(){

        productService.totalPrice();

     return "/store/cart";
    }



    @GetMapping("/addToCart")
    public String addToCart(@RequestParam("itemId") int theId){

        productService.addToCart(theId);

        Product theProduct = productService.findById(theId);
        Cart theCart = new Cart();


        //Add info to the cart
        theCart.setQuantity(theCart.getQuantity()+1);
        theCart.setProduct_name(theProduct.getName());
        theCart.setPrice(theProduct.getPrice());

        cartService.save(theCart);

        return "redirect:/store/list";
    }


    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User theUser){

        userService.save(theUser);

        return "/loginpath/login";
    }


    @RequestMapping("/showFormForReg")
    public String showFormForReg(Model theModel){

        User theUser = new User();

        theModel.addAttribute("user", theUser);

        return "loginpath/registration";

    }

}
