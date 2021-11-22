package com.cloud.productservice.controller;

import com.cloud.productservice.model.Coupon;
import com.cloud.productservice.model.Product;
import com.cloud.productservice.repository.ProductRepository;
import com.cloud.productservice.restclients.CouponClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    CouponClient couponClient;

    @Autowired
    ProductRepository repo;

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        Coupon coupon = couponClient.getCoupon(product.getCouponCode());
        product.setPrice(product.getPrice().subtract(BigDecimal.valueOf(Double.parseDouble(coupon.getDiscount()))));
        return repo.save(product);
    }

}
