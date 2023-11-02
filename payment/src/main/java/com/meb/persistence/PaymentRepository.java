package com.meb.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meb.model.PaymentModel;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel,Integer>{
    
    PaymentModel findBySyskey(int syskey);
}
