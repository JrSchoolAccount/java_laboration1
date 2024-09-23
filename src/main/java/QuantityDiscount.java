public class QuantityDiscount extends BaseDiscount{
    public QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.quantity() > 10;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.quantity() * 0.4;
    }

    @Override
    public double apply(Product product) {

        return 0;
    }

    @Override
    public String getDescription(Product product) {

        return "Quantity Discount";
    }
}
