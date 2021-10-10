package com.company;

import java.util.Scanner;

/*

Write a program to read in Stock Names, Number of Share, Share Price.
Print a Stock Report with the total value of each Stock and the total value of
Stock.
 */
public class StockAccountManagement {

    MyLinkedList<StockPortfolio> list;

    public static void main(String[] args) {

        StockAccountManagement report = new StockAccountManagement();    //	class object
        report.getStockData();
        report.printReport();
    }


    void getStockData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of stocks: ");
        int count = scanner.nextInt();
        list = new MyLinkedList<StockPortfolio>();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter stock name, number of shares and share price: ");
            String name = scanner.next();
            int numberOfShares = scanner.nextInt();
            int price = scanner.nextInt();
            StockPortfolio stock = new StockPortfolio(name, numberOfShares, price);
            list.add(stock);
        }
        scanner.close();
    }


    void printReport() {
        int totalValue = 0;
        System.out.println("\nName\tShares\tPrice\tValue");
        while (!list.isEmpty()) {
            StockPortfolio folio = list.pop(0);
            totalValue += folio.getValue();
            System.out.println(folio.getName() + "\t" + folio.getNumberOfShares()
                    + "\t" + folio.getPrice() + " \t" + folio.getValue());
        }
        System.out.println("\nTotal value is: " + totalValue);
    }
}

