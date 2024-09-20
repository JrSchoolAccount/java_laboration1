public abstract class BaseDiscount implements Discount {
    protected abstract boolean isApplicable(Product product);

    protected abstract double calculateDiscount(Product product);
}
