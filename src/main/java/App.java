import discounts.Discount;
import discounts.FridayDiscount;
import discounts.MilkDiscount;
import discounts.QuantityDiscount;
import product.Product;
import product.ProductType;

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
        double pricePerUnit = Math.floor((price - totalDiscount) * 100) / 100;
        int quantity = product.quantity();
        String appliedDiscountsText = discount.getDescription(product);
        double totalPrice = Math.floor((quantity * pricePerUnit) * 100) / 100;

        String output = String.format(
                "\nproduct.Product: %s\nQuantity: %d\nPrice per unit: %.2f kr\nDiscount per unit: %.2f kr\nApplied discounts: %s\nTotal: %.2f kr",
                product.name(),
                quantity,
                pricePerUnit,
                totalDiscount,
                appliedDiscountsText,
                totalPrice
        );

        System.out.println(output);
}
}
