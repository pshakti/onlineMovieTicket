package com.bookmyshow.entity;

import com.bookmyshow.model.PaymentDetails;
import com.bookmyshow.model.PaymentMethod;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Payment {

    private String paymentId;

    private String userId;

    private String bookId;

    private PaymentMethod paymentMethod;

    private PaymentDetails paymentDetails;

    private double amount;
}
