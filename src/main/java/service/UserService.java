package service;

import model.User;
import repository.UserRepository;

import java.io.IOException;
import java.sql.SQLException;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
