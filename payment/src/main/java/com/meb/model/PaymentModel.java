package com.meb.model;



import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Entity
@Data
@NamedQuery(name = "PaymentModel.findBySyskey", query = "SELECT p FROM PaymentModel  p WHERE p.syskey = :syskey")
public class PaymentModel {
    
    private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
    @Column(name = "syskey", nullable = true)
    @NotNull
	private int syskey;
    @NotNull
	private int order_syskey;
    @NotNull
	private double total_price;
    @NotNull
    private String status ;
    @NotNull
    private boolean delete_status;

}
