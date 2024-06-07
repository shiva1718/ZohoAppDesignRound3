package org.shiva;

import java.sql.Time;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

    List<Item> allItems;
    List<Sales> allSales;
    List<Customer> allCustomers;

    public Store() {
        allCustomers = new ArrayList<>();
        allSales = new ArrayList<>();
        allCustomers = new ArrayList<>();
    }

    public Store(List<Item> allItems, List<Customer> allCustomers) {
        this.allItems = allItems;
        this.allCustomers = allCustomers;
        this.allSales = new ArrayList<>();
    }

    public Store(List<Item> allItems, List<Sales> allSales, List<Customer> allCustomers) {
        this.allItems = allItems;
        this.allSales = allSales;
        this.allCustomers = allCustomers;
    }

    public Map<Item, Integer> profitByItem() {
        Map<Item, Integer> itemProfits = new HashMap<>();
        for (Item item : allItems) {
            itemProfits.put(item, item.getNetProfit());
        }
        return itemProfits;
    }

    public Map<Customer, Integer> balanceOfCustomers() {
        Map<Customer, Integer> balances = new HashMap<>();
        for (Customer customer : allCustomers) {
            balances.put(customer, customer.getTotalPurchaseCost() - customer.getAmtPaid());
        }
        return balances;
    }

    public long salesInRange(int customerId, LocalDate start, LocalDate end) {
        long totalSales = 0;
        for (Sales invoice : allSales) {
            if (invoice.getCustomer().getId() == customerId &&
                    invoice.getDateOfPurchase().isBefore(end) &&
                    invoice.getDateOfPurchase().isAfter(start)) {
                totalSales += invoice.getTotalAmount();
            }
        }
        return totalSales;
    }

    public long totalSalesByMonth(int month) {
        long totalSales = 0;
        for (Sales invoice : allSales) {
            if (invoice.getDateOfPurchase().getMonth().getValue() == month) {
                totalSales += invoice.getTotalAmount();
            }
        }
        return totalSales;
    }

    public long totalSalesByYear(int year) {
        long totalSales = 0;
        for (Sales invoice : allSales) {
            if (invoice.getDateOfPurchase().getYear() == year) {
                totalSales += invoice.getTotalAmount();
            }
        }
        return totalSales;
    }

    public Customer topCustomer() {
        if (allCustomers.isEmpty()) {
            System.out.println("No customers found!");
            return null;
        }
        Customer topCustomer = allCustomers.get(0);
        for (Customer customer : allCustomers) {
            int totalPurchaseCost = customer.getTotalPurchaseCost();
            if (totalPurchaseCost > topCustomer.getTotalPurchaseCost()) {
                topCustomer = customer;
            }
        }
        return topCustomer;
    }

    public Item topSellingItemsInMonth(int month) {
        Map<Item, Integer> itemsSold = new HashMap<>();
        for (Sales invoice : allSales) {
            if (invoice.getDateOfPurchase().getMonth().getValue() == month) {
                for (Item purchasedItem : invoice.getPurchasedItems()) {
                    itemsSold.put(purchasedItem,
                            itemsSold.getOrDefault(purchasedItem, 0) + purchasedItem.getSellingPrice());
                }
            }
        }
        Item topItem = null;
        for (Item item : itemsSold.keySet()) {
            if (topItem == null || itemsSold.get(item) > itemsSold.get(topItem)) {
                topItem = item;
            }
        }
        return topItem;
    }

    public void addItem(Item item) {
        allItems.add(item);
    }


    public void addInvoice(Sales invoice) {
        allSales.add(invoice);
    }
}
