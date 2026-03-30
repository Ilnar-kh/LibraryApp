import model.User;

import java.util.Scanner;

public class ConsoleUI {
    public User registerUser () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя: ");
        String name = scanner.nextLine();
        System.out.println("Введите email пользователя: ");
        String email = scanner.nextLine();

        User user = new User(name, email);
        return user;
    }
}
