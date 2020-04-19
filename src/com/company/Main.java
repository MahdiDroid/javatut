package com.company;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Principal:(1k$-1M$): >> ");
            int  principal = Integer.parseInt(scanner.nextLine());
            if (!(principal >= 1000 && principal <=1_000_000)) {
                System.out.println("You should Enter between 1K and 1M $");
                continue;
            }
            while(true){
                System.out.print("Annual Interest Rate: ");
                Float  annualInterestRate = Float.parseFloat(scanner.nextLine());
                if(!(annualInterestRate >0 && annualInterestRate<30 )){
                    System.out.println("You should Enter between  0 and 30 % ");
                    continue;
                }
                System.out.print("Period (Years) ");
                int  periodInYear = Integer.parseInt(scanner.nextLine());
                System.out.print("mortgage: ");
                System.out.println(getMortgage(principal,annualInterestRate,periodInYear));
                break;

            }

        }









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
