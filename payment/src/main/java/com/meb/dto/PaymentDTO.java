package com.meb.dto;

import lombok.Data;

@Data
public class PaymentDTO {

    private int id;
    private int syskey;
	private int order_syskey;
	private double total_price;
    private String status ;
    private boolean delete_status;

}