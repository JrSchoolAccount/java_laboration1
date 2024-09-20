public class FridayDiscount extends BaseDiscount {
    @Override
    protected boolean isApplicable(Product product) {
        return false;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 0;
    }

    @Override
    public void apply(Product product) {

    }

    @Override
    public void getDescription(Product product) {

    }
}
