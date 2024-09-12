package studio2;
import java.util.Scanner;
import java.lang.Math;

public class Ruin {

    public static void main(String[] args) {

        double initialAmount;
        double startAmount;
        double winChance;
        int winLimit;
        int totalSimulations;
        double wins = 0;
        double losses = 0;
        double expectedRuin;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the value for startAmount:");
        initialAmount = in.nextDouble();

        System.out.println("Enter the percentage for winChance as a whole number:");
        winChance = in.nextDouble();
        winChance /= 100;

        System.out.println("Enter the value for winLimit:");
        winLimit = in.nextInt();

        System.out.println("Enter the value for totalSimulations:");
        totalSimulations = in.nextInt();

        for (int i = 0; i < totalSimulations; i++) {
            startAmount = initialAmount;
            int whileCounter = 0;

            while (startAmount > 0 && startAmount < winLimit) {
                whileCounter++;

                double randomNumber = Math.random();

                if (winChance > randomNumber) {
                    startAmount++;
                } else {
                    startAmount--;
                }

                if (startAmount >= winLimit) {
                    wins++;
                    System.out.println("Simulation " + (i + 1) + ": " + whileCounter + " WIN");
                    break;
                } else if (startAmount <= 0) {
                    losses++;
                    System.out.println("Simulation " + (i + 1) + ": " + whileCounter + " LOSS");
                    break;
                }
            }
        }

        System.out.println("Total Wins: " + wins);
        System.out.println("Total Losses: " + losses);
        
        double a = (1 - winChance)/winChance;
        
        if (winChance == 0.5) {
        	expectedRuin = 1 - (startAmount/winLimit);
        } else {
        	expectedRuin = ((Math.pow(a, startAmount) - Math.pow(a, winLimit))/(1-Math.pow(a, winLimit)));

        	}
        }
        
    	System.out.println("Ruin Rate From Simulation: " + losses/totalSimulations);
    
    	System.out.println("Expected Ruin Rate From Simulation: " + expectedRuin);
        
        

    }

