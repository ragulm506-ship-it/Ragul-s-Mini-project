import java.util.HashMap;
import java.util.Scanner;

public class SimpleCurrencyConverter {

    public static void main(String[] args) {
        // 1. Setup - Create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // 2. Define Exchange Rates (Base: 1 USD)
        // We use a HashMap to store currency codes and their values
        HashMap<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.00);   // Base currency
        exchangeRates.put("EUR", 0.93);   // Euro
        exchangeRates.put("GBP", 0.79);   // British Pound
        exchangeRates.put("INR", 83.00);  // Indian Rupee
        exchangeRates.put("JPY", 150.0);  // Japanese Yen
        exchangeRates.put("CAD", 1.36);   // Canadian Dollar

        System.out.println("Welcome to the Simple Currency Converter!");
        System.out.println("Available currencies: USD, EUR, GBP, INR, JPY, CAD");
        System.out.println("-----------------------------------------------");

        // 3. Get Amount
        System.out.print("Enter amount to convert: ");
        double amount = 0;
        try {
            amount = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Invalid number. Please restart.");
            return;
        }

        // 4. Get 'From' Currency
        System.out.print("Convert FROM (e.g. USD): ");
        String fromCode = scanner.next().toUpperCase();

        // 5. Get 'To' Currency
        System.out.print("Convert TO (e.g. EUR): ");
        String toCode = scanner.next().toUpperCase();

        // 6. Validate and Calculate
        if (exchangeRates.containsKey(fromCode) && exchangeRates.containsKey(toCode)) {
            
            double fromRate = exchangeRates.get(fromCode);
            double toRate = exchangeRates.get(toCode);

            // Logic: Convert 'From' to USD, then USD to 'To'
            // Formula: (Amount / FromRate) * ToRate
            double result = (amount / fromRate) * toRate;

            // 7. Display Result (formatted to 2 decimal places)
            System.out.printf("Success: %.2f %s is equal to %.2f %s%n", 
                amount, fromCode, result, toCode);

        } else {
            System.out.println("Error: One or both currency codes are not supported.");
        }

        scanner.close();
    }
}