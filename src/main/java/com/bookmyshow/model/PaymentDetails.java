package com.bookmyshow.model;

import lombok.Data;

@Data
public class PaymentDetails {

    private String bankName;
    private String accountNumber;
    private String cardNumber;
    private String upiId;

}
