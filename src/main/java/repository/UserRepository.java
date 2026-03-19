package repository;

import com.sun.tools.javac.Main;
import db.DatabaseConnection;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

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
