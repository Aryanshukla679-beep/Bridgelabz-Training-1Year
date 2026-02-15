public class ProfitCalculator {
    public static void main(String[] args) {
        // Given values
        double costPrice = 129.0;
        double sellingPrice = 191.0;
        
        // Logic: Calculate Profit and Profit Percentage
        double profit = sellingPrice - costPrice;
        double profitPercentage = (profit / costPrice) * 100;
        
        // Using a single print statement for multiline output
        System.out.println("The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellingPrice + 
                           "\nThe Profit is INR " + profit + " and the Profit Percentage is " + profitPercentage);
    }
}