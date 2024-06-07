package org.shiva;

import java.time.LocalDate;
import java.util.*;

public class Customer {
    private final int id;
    private String name;
    private int totalPurchaseCost;
    private int amtPaid;
    private Map<Integer, Sales> purchases;

    public static int counter = 0;

    public Customer(String name) {
        this.id = counter++;
        this.name = name;
        purchases = new HashMap<>();
    }

    public void makePurchase(Store store, List<Item> items, LocalDate dateOfPurchase) {
        for (Item item : items) {
            totalPurchaseCost += item.getSellingPrice();
            item.incrementProfit();
        }
        Sales invoice = new Sales(this, items, dateOfPurchase, totalPurchaseCost);
        store.addInvoice(invoice);
        purchases.put(invoice.getId(), invoice);
    }

    public boolean makePayment(PaymentType paymentType, int amountPaid, int purchaseId, LocalDate datePaid) {
        Sales sales = purchases.get(purchaseId);
        if (sales == null) {
            System.out.println("Such Invoice not found for customer!");
            return false;
        }
        sales.makePayment(paymentType, amountPaid, datePaid);
        this.amtPaid += amountPaid;
        return true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPurchaseCost() {
        return totalPurchaseCost;
    }

    public int getAmtPaid() {
        return amtPaid;
    }

    @Override
    public String toString() {
        return name;
    }
}
