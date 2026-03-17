package db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    public static Connection getConnection() throws IOException, SQLException {
        Properties properties = new Properties();

        try (InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (inputStream == null) {
                throw new IOException("Конфигурационный файл не найден");
            }
            properties.load(inputStream);

            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            return DriverManager.getConnection(url, username, password);
        }
    }
}