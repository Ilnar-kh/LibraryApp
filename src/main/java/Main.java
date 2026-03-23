import db.DatabaseConnection;
import model.User;
import org.flywaydb.core.Flyway;
import service.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        ConsoleUI consoleUI = new ConsoleUI();
        UserService userService = new UserService();

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (inputStream != null) {
                Properties properties = new Properties();
                properties.load(inputStream);
                String url = properties.getProperty("db.url");
                String username = properties.getProperty("db.username");
                String password = properties.getProperty("db.password");

                Flyway flyway = Flyway.configure()
                        .dataSource(url, username, password)
                        .load();

                flyway.migrate();
            }
        }
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