import java.util.*;

public class Main {

    static class Product {
        String name;
        double price;
        int quantity;

        Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        double total() {
            return price * quantity;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Product> cart = new ArrayList<>();

        try {

            System.out.print("Enter number of products: ");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {

                System.out.print("Enter Product Name: ");
                String name = sc.next();

                System.out.print("Enter Price: ");
                double price = sc.nextDouble();

                if (price < 0)
                    throw new Exception("Price cannot be negative");

                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();

                if (qty <= 0)
                    throw new Exception("Quantity must be positive");

                cart.add(new Product(name, price, qty));
            }

            double totalBill = 0;

            System.out.println("------ BILL DETAILS ------");

            for (Product p : cart) {
                double itemTotal = p.total();
                System.out.println(p.name + " x " + p.quantity + " = " + itemTotal);
                totalBill += itemTotal;
            }

            System.out.println("---------------------------");
            System.out.println("Total Bill Amount = " + totalBill);

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }
    }
}