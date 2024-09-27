package discounts;

import product.Product;

import java.util.Optional;

public abstract class BaseDiscount implements Discount {
    protected Optional<Discount> nextDiscount;

    public BaseDiscount(Optional<Discount> nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    protected abstract boolean isApplicable(Product product);
    protected abstract double calculateDiscount(Product product);
    protected abstract String getDiscountDescription(Product product);

    @Override
    public double apply(Product product) {
        double discount = 0;

        if (isApplicable(product)) {
           discount = calculateDiscount(product);
        }
        double totalDiscount = discount + nextDiscount.map(d -> d.apply(product)).orElse(0.0);

        return Math.floor(totalDiscount * 100) / 100;
    }

    @Override
    public String getDescription(Product product) {
        String currentDescription = isApplicable(product) ? getDiscountDescription(product) : "";
        String nextDescription = nextDiscount.map(d -> d.getDescription(product)).orElse("");

        if (!currentDescription.isEmpty() && !nextDescription.isEmpty()) {
            return currentDescription + " + " + nextDescription;
        }

        return currentDescription.isEmpty() ? nextDescription : currentDescription;
    }

}
