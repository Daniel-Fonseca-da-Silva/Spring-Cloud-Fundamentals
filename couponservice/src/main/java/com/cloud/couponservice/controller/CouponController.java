package com.cloud.couponservice.controller;

import com.cloud.couponservice.model.Coupon;
import com.cloud.couponservice.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponRepository repo;

    @RequestMapping(value = "/coupons", method = RequestMethod.POST)
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        return repo.save(coupon);
    }

    @RequestMapping(value = "/coupons/{code}", method = RequestMethod.GET)
    public Coupon getCoupon(@PathVariable("code") String code) {
        return repo.findByCode(code);
    }

}
