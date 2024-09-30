import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static double getDouble(String prompt) {
        double num = 0;
        boolean correctInput = false;

        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br =  new BufferedReader(sr);

        do {
            try {
                System.out.print(prompt);
                String raw_input = br.readLine();
                num = Double.parseDouble(raw_input);
                correctInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input, try again");
            }

        } while (!correctInput);

        return num;
    }

    static void outputInfo(double gallons, double fuelEff, double gasPrice, double distance) {
        double gallonsNeeded = distance / fuelEff;
        double totalGasPrice = gallonsNeeded * gasPrice;
        double totalDistance = gallons * fuelEff;
        System.out.println();
        System.out.printf("Price for 100 miles: $%.2f\nDistance with one tank %.2f miles", totalGasPrice, totalDistance);
    }
    public static void main(String[] args) {
        double gallons = getDouble("How many gallons are in the tank? ");
        double fuelEff = getDouble("What is your fuel efficieny in miles per gallon? ");
        double gasPrice = getDouble("What is the price of gas per gallon? ");
        outputInfo(gallons, fuelEff, gasPrice, 100);
    }
}
