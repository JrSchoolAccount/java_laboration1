package discounts;

import product.Product;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class GenericDiscount extends BaseDiscount {

    private final Predicate<Product> isApplicable;
    private final Function<Product, Double> calculateDiscount;
    private final String description;

    public GenericDiscount(Predicate<Product> isApplicable,
                           Function<Product, Double> calculateDiscount,
                           String description,
                           Optional<Discount> nextDiscount) {
        super(nextDiscount);
        this.isApplicable = isApplicable;
        this.calculateDiscount = calculateDiscount;
        this.description = description;
    }

    @Override
    protected boolean isApplicable(Product product) {
        return isApplicable.test(product);
    }

    @Override
    protected double calculateDiscount(Product product) {
        return calculateDiscount.apply(product);
    }

    @Override
    protected String getDiscountDescription(Product product) {
        return description;
    }
}
