import java.util.Scanner;

// Демонстрация работы системы управления заказами в ресторане
public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Dish\n2. Update Price\n3. Remove Dish\n4. Display Menu\n5. Place Order\n6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter dish name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    Dish dishToAdd = new Dish(name, price);
                    menu.setOperation(new AddDishOperation());
                    menu.executeOperation(dishToAdd);
                    break;
                case 2:
                    System.out.print("Enter dish name to update price: ");
                    String nameToUpdate = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine(); // Дополнительный вызов nextLine() для очистки входного потока
                    menu.setOperation(new UpdatePriceOperation(newPrice));
                    menu.executeOperation(new Dish(nameToUpdate, 0));
                    break;

                case 3:
                    System.out.print("Enter dish name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    menu.setOperation(new RemoveDishOperation());
                    menu.executeOperation(new Dish(nameToRemove, 0));
                    break;
                case 4:
                    menu.displayMenu();
                    break;
                case 5:
                    Order order = new Order();
                    System.out.println("Enter the names of the dishes you want to order (type 'done' to finish):");
                    while (true) {
                        String dishName = scanner.nextLine();
                        if ("done".equalsIgnoreCase(dishName)) {
                            break;
                        }
                        Dish orderedDish = menu.getDishByName(dishName);
                        if (orderedDish != null) {
                            order.addDish(orderedDish);
                            System.out.println(dishName + " added to your order.");
                        } else {
                            System.out.println("Dish not found. Please try again.");
                        }
                    }
                    System.out.println(order);
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please enter a number between 1 and 6.");
            }
        }
    }
}
