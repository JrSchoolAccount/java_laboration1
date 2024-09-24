import java.util.Optional;

public abstract class BaseDiscount implements Discount {
    protected Optional<Discount> nextDiscount;

    public BaseDiscount(Optional<Discount> nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    protected abstract boolean isApplicable(Product product);
    protected abstract double calculateDiscount(Product product);


    @Override
    public double apply(Product product) {
        double discount = 0;

        if (isApplicable(product)) {
           discount = calculateDiscount(product);
        }
        return discount + nextDiscount.map(d -> d.apply(product)).orElse(0.0);
    }

    @Override
    public String getDescription(Product product) {
        return null;
    }

}
