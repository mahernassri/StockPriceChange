package org.example;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner getInput = new Scanner(System.in);
        System.out.println("Enter purchase price (per share): ");
        BigDecimal purchasePrice = getInput.nextBigDecimal();

        int days = 1;
        BigDecimal closePrice = BigDecimal.valueOf(0.01);

        while (true)
        {
            System.out.println("Enter the closing price for day: " + days + " (any negative value to exit");
            closePrice = getInput.nextBigDecimal();

            if (closePrice.compareTo(BigDecimal.ZERO) < 0) break;
            BigDecimal earnings = closePrice.subtract(purchasePrice);

            if (earnings.compareTo(BigDecimal.ZERO) > 0)
            {
                System.out.println("After day " + days + " , you earned $" + earnings.setScale(2, RoundingMode.HALF_UP) + " per share.");
            } else if (earnings.compareTo(BigDecimal.ZERO) < 0)
            {
                System.out.println("After day " + days + " , you lost $" + earnings.setScale(2, RoundingMode.HALF_UP) + " per share.");
            } else
            {
                System.out.println("After day " + days + ", you have broken even.");
            }

            days++;
        }
        getInput.close();
    }
}