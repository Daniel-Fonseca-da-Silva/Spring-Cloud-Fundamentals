package com.cloud.productservice.restclients;

import com.cloud.productservice.model.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("COUPON-SERVICE")
public interface CouponClient {
    @GetMapping("/coupon/coupons/{code}")
    Coupon getCoupon(@PathVariable("code") String code);
}
