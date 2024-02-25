import java.util.ArrayList;
import java.util.List;

// Управление меню ресторана
public class Menu {
    private List<Dish> dishes = new ArrayList<>(); // Список блюд в меню
    private MenuOperation operation; // Поле для хранения текущей операции

    // Устанавливает операцию для выполнения
    public void setOperation(MenuOperation operation) {
        this.operation = operation;
    }

    // Выполняет установленную операцию
    public void executeOperation(Dish dish) {
        operation.execute(dishes, dish); // Вызов метода execute текущей операции
    }

    // Выводит текущее меню
    public void displayMenu() {
        System.out.println("Menu:");
        for (Dish dish : dishes) {
            System.out.println(dish);
        }
    }

    // Получить блюдо по его названию
    public Dish getDishByName(String name) {
        for (Dish dish : dishes) {
            if (dish.getName().equalsIgnoreCase(name)) {
                return dish;
            }
        }
        return null;
    }
}
