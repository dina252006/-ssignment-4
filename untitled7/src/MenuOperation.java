import java.util.List;

// Определяет интерфейс для операций над меню
public interface MenuOperation {
    void execute(List<Dish> dishes, Dish dish);
}
