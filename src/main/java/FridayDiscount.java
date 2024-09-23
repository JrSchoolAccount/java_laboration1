import java.time.DayOfWeek;
import java.time.LocalDate;

public class FridayDiscount extends BaseDiscount {
    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * 0.2;
    }

    @Override
    public double apply(Product product) {

        return 0;
    }

    @Override
    public String getDescription(Product product) {

        return "Friday Discount";
    }
}
