package repository;

import model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email) throws SQLException, IOException;

    User save(User user) throws SQLException, IOException;
}
