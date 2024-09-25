import java.util.Optional;

public class App {

    public static void main(String[] args) {
        Product milk = new Product("Milk", 22, 1, ProductType.MILK);

        Discount discount = new FridayDiscount(Optional.of(new MilkDiscount(Optional.of(new QuantityDiscount(Optional.empty())))));

        double totalDiscount = discount.apply(milk);
        double price = milk.price();
        double discountedPrice = price - totalDiscount;

        System.out.println("Product: " + milk.name() +
                "\nPrice per unit: " + discountedPrice + ":-" +
                "\nDiscount per unit: " + totalDiscount + ":-" +
                "\nApplied discounts: ");
    }
}
