package com.vicketrossing.springbootproject.controller;

import com.vicketrossing.springbootproject.entity.Cart;
import com.vicketrossing.springbootproject.entity.Product;
import com.vicketrossing.springbootproject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;



    @GetMapping("/delete")
    public String deleteItem(@RequestParam("itemId") int theId){

        cartService.deleteById(theId);

        return "redirect:/cart/listCart";
    }

    @GetMapping("/listCart")
    public String listCart(Model theModel){
          List<Cart> theOrder = cartService.findAllOrder();

        System.out.println(theOrder);

        theModel.addAttribute("order", theOrder);



        System.out.println(theOrder);
        return "/store/cart";
    }


    @GetMapping("/asdf")
    public String listTotal(Model theModel){

        Cart theCart = cartService.theTotal();
        Cart newCart = new Cart();
        double sum;

        sum = newCart.getPrice()*newCart.getQuantity();

        theModel.addAttribute("total", sum);

        return "/store/cart";
    }



    @GetMapping("/ordercomplete")
    public String orderComplete(){

        List<Cart> theCart = cartService.findAllOrder();

        if(theCart.isEmpty()){

            return "redirect:/store/list";

        }else{
            cartService.deleteAll();

            return "/store/ordercomplete";
        }
    }

}
