public abstract class BaseDiscount implements Discount {
    protected Discount nextDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    protected abstract boolean isApplicable(Product product);
    protected abstract double calculateDiscount(Product product);


    @Override
    public double apply(Product product) {
        if (isApplicable(product)) {
            return calculateDiscount(product);
        }
        if (nextDiscount != null) {
            return nextDiscount.apply(product);
        }
        return 0;
    }

    @Override
    public String getDescription(Product product) {
        if (isApplicable(product)) {
            return "Discount: " + calculateDiscount(product);
        }
        if (nextDiscount != null) {
            return nextDiscount.getDescription(product);
        }
        return "No Discount";
    }
}
