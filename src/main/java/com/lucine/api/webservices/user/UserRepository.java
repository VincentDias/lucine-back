package com.lucine.api.webservices.user;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/lucine?serverTimezone=GMT";
    private final static String DB_USER = "lucine";
    private final static String DB_PASSWORD = "lucine";

    public List<User> findAll(){

        List<User> users = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM user;"
            );
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String lastName = resultSet.getString("lastname");
                String firstName = resultSet.getString ("firstname");
                String role = resultSet.getString("role");
                String mail = resultSet.getString("mail");
                users.add(new User(id, login, password, lastName, firstName, role, mail));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return users;

    }
}

