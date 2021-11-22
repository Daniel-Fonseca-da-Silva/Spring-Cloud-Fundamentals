package com.cloud.productservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Coupon {

    private Long id;
    private String code;
    private String discount;
    private String expDate;

}
