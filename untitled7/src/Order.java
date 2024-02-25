import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Dish> dishes = new ArrayList<>();
    private double totalCost = 0;

    public void addDish(Dish dish) {
        dishes.add(dish);
        totalCost += dish.getPrice();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Details:\n");
        for (Dish dish : dishes) {
            sb.append(dish.getName()).append(" - $").append(String.format("%.2f", dish.getPrice())).append("\n");
        }
        sb.append("Total Cost: $").append(String.format("%.2f", totalCost));
        return sb.toString();
    }
}
