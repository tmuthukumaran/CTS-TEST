import java.util.HashMap;
import java.util.Map;

public class FinancialForecast {
    // 1. Simple Recursive Method
    public static double calculateFutureValueRecursive(double initialValue, double[] growthRates, int year) {
        if (year == growthRates.length) {
            return initialValue;
        }
        double newValue = initialValue * (1 + growthRates[year]);
        return calculateFutureValueRecursive(newValue, growthRates, year + 1);
    }

    // 2. Recursive with Memoization
    static Map<Integer, Double> memo = new HashMap<>();
    public static double calculateFutureValueMemo(double initialValue, double[] growthRates, int year) {
        if (year == growthRates.length) {
            return initialValue;
        }
        if (memo.containsKey(year)) {
            return memo.get(year);
        }
        double newValue = initialValue * (1 + growthRates[year]);
        double result = calculateFutureValueMemo(newValue, growthRates, year + 1);
        memo.put(year, result);
        return result;
    }
    // 3. Iterative Version
    public static double calculateFutureValueIterative(double initialValue, double[] growthRates) {
        double futureValue = initialValue;
        for (double rate : growthRates) {
            futureValue *= (1 + rate);
        }
        return futureValue;
    }
    // Main Method to Compare All
    public static void main(String[] args) {
        double initialValue = 1000.0;
        double[] growthRates = {0.05, 0.07, 0.03};  // 3 years growth

        // Clear memoization map before use
        memo.clear();

        // Method 1: Simple Recursion
        double valueRecursive = calculateFutureValueRecursive(initialValue, growthRates, 0);
        System.out.println("Future Value (Recursive): " + valueRecursive);

        // Method 2: Recursive with Memoization
        double valueMemo = calculateFutureValueMemo(initialValue, growthRates, 0);
        System.out.println("Future Value (Memoization): " + valueMemo);

        // Method 3: Iterative
        double valueIterative = calculateFutureValueIterative(initialValue, growthRates);
        System.out.println("Future Value (Iterative): " + valueIterative);
    }
}
