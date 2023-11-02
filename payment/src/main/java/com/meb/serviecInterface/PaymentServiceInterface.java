package com.meb.serviecInterface;

import org.springframework.stereotype.Service;

import com.meb.dto.DataResponse;
import com.meb.dto.PaymentDTO;




@Service
public interface PaymentServiceInterface {
    
    DataResponse savePayment(PaymentDTO paymentDTO);

    DataResponse deletePayment(int syskey);


}
