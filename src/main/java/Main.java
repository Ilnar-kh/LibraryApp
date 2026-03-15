import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                System.out.println("Подключение к БД успешно");
            }
        } catch (SQLException|IOException e) {
            System.err.println("Ошибка подключения" + e.getMessage());
        }
    }
}