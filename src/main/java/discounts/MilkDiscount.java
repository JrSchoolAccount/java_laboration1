package discounts;

import product.Product;
import product.ProductType;

import java.util.Optional;

public class MilkDiscount extends BaseDiscount{
    public MilkDiscount(Optional<Discount> nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.type() == ProductType.MILK;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * 0.05;
    }

    @Override
    protected String getDiscountDescription(Product product) {
        return "5% Milk Discount";
    }
}
