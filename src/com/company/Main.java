package com.company;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int principal = (int)readNumber("principal",1000,1_000_000);
        float annualInterestRate = (float)readNumber("Annual Interest Rate",0,30);
        int periodInYear = (int)readNumber("Period In Year",0,50);
        System.out.println(getMortgage(principal,annualInterestRate,periodInYear));

        }


    private  static double readNumber(String prompt,int min, int max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true){
            System.out.print(prompt+ " :");
            value = Double.parseDouble(scanner.nextLine());
            if(value < min || value > max )
                System.out.println("You should enter between " + min + " and " + max);
            break;
            }
        return value;

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




