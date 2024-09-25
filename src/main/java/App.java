import java.util.Optional;

public class App {

    public static void main(String[] args) {
        Product milk = new Product("Milk", 22, 11, ProductType.MILK);
        Product trident = new Product("Trident", 150, 1, ProductType.NOT_MILK);
        Product garlic = new Product("Garlic", 11, 30, ProductType.NOT_MILK);


        Discount discountChain =
                new QuantityDiscount(Optional.of(
                    new MilkDiscount(Optional.of(
                        new FridayDiscount(Optional.empty())))));

        applyDiscount(milk, discountChain);
        applyDiscount(trident, discountChain);
        applyDiscount(garlic, discountChain);
    }

    private static void applyDiscount(Product product, Discount discount) {
        double totalDiscount = discount.apply(product);
        double price = product.price();
        double discountedPrice = Math.floor((price - totalDiscount) * 100) / 100;
        int quantity = product.quantity();
        String appliedDiscounts = discount.getDescription(product);
        double totalPrice = Math.floor((quantity * discountedPrice) * 100) / 100;

        System.out.println("\nProduct: " + product.name() +
                "\nQuantity: " + quantity +
                "\nPrice per unit: " + discountedPrice + "kr" +
                "\nDiscount per unit: " + totalDiscount + "kr" +
                "\nApplied discounts: "+ appliedDiscounts +
                "\nTotal : " + totalPrice + " kr");
    }
}
