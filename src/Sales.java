package org.shiva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sales {
    private final int id;
    private Customer customer;
    private List<Item> purchasedItems;
    private LocalDate dateOfPurchase;
    private List<Transaction> transactions;
    private int totalAmount;
    private int amountPaid;

    public static int counter = 0;

    public Sales(Customer customer, List<Item> purchasedItems, LocalDate dateOfPurchase, int total) {
        this.id = counter++;
        this.customer = customer;
        this.purchasedItems = purchasedItems;
        this.dateOfPurchase = dateOfPurchase;
        transactions = new ArrayList<>();
        totalAmount = total;
    }

    public int getId() {
        return id;
    }

    public void makePayment(PaymentType paymentType, int amountPaid, LocalDate datePaid) {
        Transaction transaction = new Transaction(paymentType, amountPaid, datePaid, customer);
        transactions.add(transaction);
        this.amountPaid += amountPaid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getPurchasedItems() {
        return purchasedItems;
    }


    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "customer=" + customer +
                ", dateOfPurchase=" + dateOfPurchase +
                ", purchasedItems=" + purchasedItems +
                ", totalAmount=" + totalAmount +
                ", amountPaid=" + amountPaid +
                '}';
    }
}
