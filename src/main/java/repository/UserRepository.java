package repository;

import db.DatabaseConnection;
import model.User;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;

public class UserRepository {

    public Optional<User> findByEmail(String email) throws SQLException, IOException {
        String sql = "SELECT id, name, email FROM users WHERE email = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    String foundEmail = resultSet.getString("email");
                    User user = new User(id, name, foundEmail);
                    return Optional.of(user);
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    public User save(User user) throws SQLException, IOException {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        String name = user.getName();
        String email = user.getEmail();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);

            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    Long id = resultSet.getLong(1);
                    User newUser = new User(id, name, email);
                    return newUser;
                } else {
                    throw new SQLException("Ну удалось получить id пользователя");
                }
            }
        }
    }
}
