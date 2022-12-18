package com.bookmyshow.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PaymentDto {

    private String userId;
    private String bookId;

    private PaymentMethod paymentMethod;

    private PaymentDetails paymentDetails;

    private double amount;
}
