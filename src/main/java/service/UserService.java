package service;

import model.User;
import repository.UserRepository;

import java.io.IOException;
import java.sql.SQLException;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public User createUser(User user) throws SQLException, IOException {
        try {
            return userRepository.save(user);
        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())) {
                System.out.println("Пользователь с таким email уже существует");
                return null;
            }
            throw e;
        }
    }
}
