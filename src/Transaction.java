package org.shiva;

import java.time.LocalDate;

public class Transaction {
    private PaymentType paymentType;
    private int paymentAmount;
    private LocalDate paymentDate;
    private Customer customerPaid;

    public Transaction(PaymentType paymentType, int amountPaid, LocalDate datePaid, Customer customer) {
        this.paymentType = paymentType;
        this.paymentAmount = amountPaid;
        this.paymentDate = datePaid;
        this.customerPaid = customer;
    }

}
