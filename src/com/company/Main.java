package com.company;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        int  principal = Integer.parseInt(scanner.nextLine());
        System.out.print("Annual Interest Rate: ");
        Float  annualInterestRate = Float.parseFloat(scanner.nextLine());
        System.out.print("Period (Years) ");
        int  periodInYear = Integer.parseInt(scanner.nextLine());
        System.out.print("mortgage: ");
        System.out.println(getMortgage(principal,annualInterestRate,periodInYear));


    }

    private static String getMortgage(int principal,
                                      Float annualInterestRate,
                                      int periodInYear) {
         final int MONTH_IN_YEAR = 12;
         final int PERCENT=100;
        Float monthlyInterestRate = annualInterestRate / MONTH_IN_YEAR / PERCENT;
        int numberOfPayments= periodInYear * MONTH_IN_YEAR;

            double mortgage =  principal * (
                    (monthlyInterestRate * Math.pow((monthlyInterestRate + 1),numberOfPayments)) /
                            (Math.pow((monthlyInterestRate + 1),numberOfPayments) - 1)
            );
            String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
            return mortgageFormated;

    }
}
