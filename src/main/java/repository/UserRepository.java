package repository;

import db.DatabaseConnection;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {
    User save(User user) throws SQLException, IOException {
        String sql = "INSERT INTO users (username, email) VALUES (?, ?)";
        String username = user.
        String email = user.

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, email);

        return user;
    }
}
