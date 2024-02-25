import java.util.List;

// Удаление блюда из меню
public class RemoveDishOperation implements MenuOperation {
    @Override
    public void execute(List<Dish> dishes, Dish dish) {
        dishes.removeIf(d -> d.getName().equals(dish.getName()));
    }
}
