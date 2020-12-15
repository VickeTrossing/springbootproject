package com.vicketrossing.springbootproject.service;

import com.vicketrossing.springbootproject.entity.Cart;
import com.vicketrossing.springbootproject.entity.User;
import com.vicketrossing.springbootproject.repository.CartRepository;
import com.vicketrossing.springbootproject.repository.ProductRepository;
import com.vicketrossing.springbootproject.entity.Product;
import com.vicketrossing.springbootproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Product> findAll() {

        return productRepository.findAll();
    }


    @Override
    public Product findById(int theId) {
        Optional<Product> result = productRepository.findById(theId);

        Product theProduct = null;
        if(result.isPresent()){
            theProduct = result.get();
        }else{
            throw new RuntimeException("did not find product id " + theId);
        }

        return theProduct;
    }

    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }


    @Override
    public double totalPrice() {
        Cart cart = new Cart();

       double theTotal = cart.getTotalPrice();

        return theTotal;
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }


    @Override
    public Cart addToCart(int theId) {

       Optional<Product> theProduct = productRepository.findById(theId);
       Cart theCart = new Cart();


        System.out.println(theProduct.get().getStock());
        System.out.println(theProduct.get().getName());


            //Add info to the cart
            theCart.setQuantity(theCart.getQuantity()+1);
            theCart.setProduct_name(theProduct.get().getName());
            theCart.setPrice(theProduct.get().getPrice());

            //apply changes to db
            theProduct.get().setStock(theProduct.get().getStock()-1);

        System.out.println(theProduct.get().getStock());
        System.out.println(theCart.getQuantity());

        System.out.println(theCart.getProduct_name());
        System.out.println(theCart.getPrice());

        return theCart;
    }
}
