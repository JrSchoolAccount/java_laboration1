import java.util.Optional;

public class App {

    public static void main(String[] args) {
        Product milk = new Product("Milk", 22, 11, ProductType.MILK);

        Discount discount = new FridayDiscount(Optional.of(new MilkDiscount(Optional.of(new QuantityDiscount(Optional.empty())))));

        double totalDiscount = discount.apply(milk);

        System.out.println("Total discount: " + totalDiscount + ":-");
    }
}
