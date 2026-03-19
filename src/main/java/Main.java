import db.DatabaseConnection;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                System.out.println("Подключение к БД успешно");
            }
        } catch (SQLException | IOException e) {
            System.err.println("Ошибка подключения" + e.getMessage());
        }

    }

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