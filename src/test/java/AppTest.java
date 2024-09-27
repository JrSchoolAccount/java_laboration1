import discounts.GenericDiscount;
import org.junit.jupiter.api.Test;
import product.Product;
import product.ProductType;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    void shouldNotApplyDiscountWhenProductIsNotMilk(){
        Product axe = new Product("Axe", 250, 1, ProductType.NOT_MILK);

        GenericDiscount genericMilkDiscount = new GenericDiscount(
                product -> product.type() == ProductType.MILK,
                product -> product.price() * 0.05,
                "10% Milk Discount",
                Optional.empty());

        double discount = genericMilkDiscount.apply(axe);

        assertThat(discount).isEqualTo(0);
        assertThat(genericMilkDiscount.getDescription(axe)).isNotEqualTo("10% Milk Discount");
    }

    @Test
    void shouldApplyDiscountWhenProductIsMilk(){
        Product milk = new Product("Milk", 22, 5, ProductType.MILK);

        GenericDiscount milkDiscount = new GenericDiscount(
                product -> product.type() == ProductType.MILK,
                product -> product.price() * 0.05,
                "10% Milk Discount",
                Optional.empty());

        double discount = milkDiscount.apply(milk);

        assertThat(discount).isEqualTo(1.1);
        assertThat(milkDiscount.getDescription(milk)).isEqualTo("10% Milk Discount");
    }
}
