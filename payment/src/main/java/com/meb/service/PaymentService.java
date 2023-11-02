package com.meb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meb.dto.DataResponse;
import com.meb.dto.PaymentDTO;
import com.meb.model.PaymentModel;
import com.meb.persistence.PaymentRepository;
import com.meb.serviecInterface.PaymentServiceInterface;

@Service
public class PaymentService implements PaymentServiceInterface{

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public DataResponse savePayment(PaymentDTO paymentDTO) {
        DataResponse response = new DataResponse();
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setOrder_syskey(paymentDTO.getOrder_syskey());
        paymentModel.setTotal_price(paymentDTO.getTotal_price());
        paymentModel.setSyskey(paymentDTO.getSyskey());
        paymentModel.setStatus(paymentDTO.getStatus());

        try {
            paymentRepository.save(paymentModel);
            response.setDescription("Payment success");
            response.setStatus(paymentDTO.getStatus());
            response.setSyskey(paymentDTO.getSyskey());
        } catch (Exception e) {
            response.setDescription(e.getMessage());
        }

        return response;
    }

    @Override
    public DataResponse deletePayment(int syskey) {
        DataResponse response = new DataResponse();
        PaymentModel model = paymentRepository.findBySyskey(syskey); 
        if (model != null) {
            model.setDelete_status(true);
            paymentRepository.save(model); 
            response.setStatus("1");
            response.setDescription("Delete Success");
            response.setSyskey(syskey);
        } else {
            response.setDescription("Payment not found");
        }
        return response;
    }

   

 
}
