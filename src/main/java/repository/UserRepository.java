package repository;

import db.DatabaseConnection;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository {

    Optional<User> findByEmail(String email) throws SQLException, IOException {
        String sql = "SELECT * FROM users WHERE email = ?";

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,email);

        ResultSet
    }

    User save(User user) throws SQLException, IOException {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        String name = user.getName();
        String email = user.getEmail();

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);

        return user;
    }
}
