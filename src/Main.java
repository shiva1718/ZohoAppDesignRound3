package org.shiva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = initializeCustomers();
        List<Item> items = initializeItems();
        Store store = new Store(items, customers);
        customers.get(0).makePurchase(store, List.of(items.get(0), items.get(1)), LocalDate.of(2023, 5, 18));
        customers.get(1).makePurchase(store, List.of(items.get(0), items.get(1), items.get(4)), LocalDate.of(2023, 6, 18));
        customers.get(2).makePurchase(store, List.of(items.get(3), items.get(4)), LocalDate.of(2023, 6, 11));
        customers.get(3).makePurchase(store, List.of(items.get(1), items.get(2)), LocalDate.of(2023, 5, 11));

        boolean success = customers.get(1).makePayment(PaymentType.CASH, 16, 1, LocalDate.of(2023, 7, 1));

//        System.out.println(store.profitByItem());
//        System.out.println(store.balanceOfCustomers());
//        System.out.println(store.topCustomer());

//        System.out.println(store.totalSalesByMonth(6));
//        System.out.println(store.totalSalesByYear(2023));
        System.out.println(store.salesInRange(2,
                LocalDate.of(2023, 5, 9),
                LocalDate.of(2023, 6, 15)));
//        System.out.println(store.topSellingItemsInMonth(6));


    }


    public static List<Customer> initializeCustomers() {
        List<Customer> customers = new ArrayList<>();
        String[] names = {"a", "b", "c", "d", "e"};
        for (int i = 0; i < 5; i++) {
            customers.add(new Customer(names[i]));
        }
        return customers;
    }

    public static List<Item> initializeItems() {
        List<Item> items = new ArrayList<>();
        String[] names = {"ball", "bat", "shirt", "pen", "pencil"};
        for (int i = 0; i < 5; i++) {
            items.add(new Item(10, 12, names[i]));
        }
        return items;
    }


}