import java.util.Optional;

public class QuantityDiscount extends BaseDiscount{
    public QuantityDiscount(Optional<Discount> nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.quantity() >= 10;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 10;
    }

    @Override
    protected String getDiscountDescription(Product product) {
        return "Quantity Discount";
    }
}
