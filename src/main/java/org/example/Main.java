package org.example;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner getInput = new Scanner(System.in);
        System.out.print("Enter purchase price (per share): ");
        BigDecimal purchasePrice = getInput.nextBigDecimal();
        ArrayList<BigDecimal> priceList = new ArrayList<>();
        priceList.add(purchasePrice);

        int days = 1;
        BigDecimal closePrice = BigDecimal.valueOf(0.01);

        while (closePrice.compareTo(BigDecimal.ZERO) > 0.00)
        {
            System.out.print("Enter the closing price for day: " + days + " (any negative value to exit: ");
            closePrice = getInput.nextBigDecimal();

            if (closePrice.compareTo(BigDecimal.ZERO) < 0)
            {
                BigDecimal profitLoss = priceList.get((priceList.size() - 1)).subtract(purchasePrice);
                System.out.println("Final profit/loss is: $" + profitLoss.setScale(2, RoundingMode.HALF_UP));
                System.out.println("Negative value detected.  Exiting...");
                break;
            }
            BigDecimal earnings = closePrice.subtract(purchasePrice);

            if (earnings.compareTo(BigDecimal.ZERO) > 0)
            {
                System.out.println("After day " + days + " , you earned $" + earnings.setScale(2, RoundingMode.HALF_UP) + " per share.");
                priceList.add(closePrice);
            } else if (earnings.compareTo(BigDecimal.ZERO) < 0)
            {
                System.out.println("After day " + days + " , you lost $" + earnings.setScale(2, RoundingMode.HALF_UP) + " per share.");
                priceList.add(closePrice);
            } else
            {
                System.out.println("After day " + days + ", you have broken even.");
                priceList.add(closePrice);
            }
            days++;
        }
        getInput.close();
    }
}