import java.util.List;

// Обновление цены блюда
public class UpdatePriceOperation implements MenuOperation {
    private double newPrice;

    public UpdatePriceOperation(double newPrice) {
        this.newPrice = newPrice;
    }

    @Override
    public void execute(List<Dish> dishes, Dish dish) {
        for (Dish d : dishes) {
            if (d.getName().equals(dish.getName())) {
                d.setPrice(newPrice);
                break;
            }
        }
    }
}
