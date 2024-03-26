import java.util.Scanner;

public class Transaction {
    private final int max_coupons = 15;
    private final int[] couponCodes = {
            123456, 234567, 345678, 456789, 567890,
            678901, 789012, 890123, 901234, 102345,
            987654, 876543, 765432, 654321, 543210
    };

    private boolean isValidCoupon(int code) {
        // Check if the provided coupon code matches any of the predefined coupon codes
        for (int couponCode : couponCodes) {
            if (couponCode == code) {
                return true;
            }
        }
        return false;
    }

    public double processOrder(Cart cart) {
        Scanner scanner = new Scanner(System.in);
        double total = cart.getTotal(); // Initialize total with the cart total
        String answer;
        System.out.println("Do you have a discount coupon? (yes/no)");
        answer = scanner.nextLine().toLowerCase();

        if (answer.equals("yes")) {
            System.out.print("Enter the coupon code: ");
            int couponCode = Integer.parseInt(scanner.nextLine());

            // Check if the entered coupon code is valid and does not exceed the maximum
            // number of coupons
            if (isValidCoupon(couponCode) && couponCode <= max_coupons) {
                if (cart.getItems().size() > 5) {
                    total *= 0.95; // Apply 5% discount for more than 5 items
                    System.out.println("5% discount applied for purchasing more than 5 items!");
                } else {
                    total *= 0.85; // Apply 15% discount for a single item
                    System.out.println("15% discount applied successfully!");
                }
            } else {
                System.out.println("Invalid coupon code or maximum coupons exceeded.");
            }
        }
        scanner.close();
        return total; // Return the total after applying discounts
    }
}
