import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

public class FridayDiscount extends BaseDiscount {
    public FridayDiscount(Optional<Discount> nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * 0.1;
    }

    @Override
    protected String getDiscountDescription(Product product) {
        return "10% Friday Discount";
    }
}
