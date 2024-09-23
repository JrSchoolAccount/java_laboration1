public class FridayDiscount extends BaseDiscount {
    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return false;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 0;
    }

    @Override
    public double apply(Product product) {

        return 0;
    }

    @Override
    public String getDescription(Product product) {

        return null;
    }
}
