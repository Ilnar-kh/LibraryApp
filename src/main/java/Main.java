import db.DatabaseConnection;
import model.User;
import service.UserService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        ConsoleUI consoleUI = new ConsoleUI();
        UserService userService = new UserService();

        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                System.out.println("Подключение к БД успешно");
            }
        } catch (SQLException | IOException e) {
            System.err.println("Ошибка подключения" + e.getMessage());
        }

        User user = consoleUI.registerUser();
        userService.createUser(user);
    }
}