import java.util.List;

// Добавление блюда в меню
public class AddDishOperation implements MenuOperation {
    @Override
    public void execute(List<Dish> dishes, Dish dish) {
        dishes.add(dish);
    }
}
