package com.meb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.meb.dto.DataResponse;
import com.meb.dto.PaymentDTO;
import com.meb.serviecInterface.PaymentServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PaymentController {

    @Autowired
    private PaymentServiceInterface serviceInterface;

    @PostMapping(value="/savePayment")
    public DataResponse saveOrder(@RequestBody PaymentDTO paymentDTO)
    {
        DataResponse res= new DataResponse();
        res = serviceInterface.savePayment(paymentDTO);
        return  res;
        
    }


    @DeleteMapping("/deletePayment/{syskey}")
    @ResponseBody
    public DataResponse deletePaymentById(@PathVariable int syskey) {
    DataResponse response = serviceInterface.deletePayment(syskey);
    return response;
}



}