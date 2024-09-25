import java.util.Optional;

public class App {

    public static void main(String[] args) {
        Product milk = new Product("Milk", 22, 11, ProductType.MILK);

        Discount discount = new QuantityDiscount(Optional.of(new MilkDiscount(Optional.of(new FridayDiscount(Optional.empty())))));

        double milkDiscount = Math.floor((discount.apply(milk)) * 100) / 100;
        double price = milk.price();
        double discountedPrice = Math.floor((price - milkDiscount) * 100) / 100;
        String appliedDiscounts = discount.getDescription(milk);

        System.out.println("Product: " + milk.name() +
                "\nPrice per unit: " + discountedPrice + ":-" +
                "\nDiscount per unit: " + milkDiscount + ":-" +
                "\nApplied discounts: "+ appliedDiscounts);
    }
}
