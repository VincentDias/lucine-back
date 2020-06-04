package com.lucine.api.webservices.user;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final static String DB_URL = System.getenv("lucine_db_url");
    private final static String DB_USER = System.getenv("lucine_db_user");
    private final static String DB_PASSWORD = System.getenv("lucine_db_password");

    public List<User> findAll() {

        List<User> users = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM User;"
            );
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String lastName = resultSet.getString("lastname");
                String firstName = resultSet.getString("firstname");
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

    public User authUser(String userLogin) {

        User currentUser = null;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM User where id = 1"
            );
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String lastName = resultSet.getString("lastname");
                String firstName = resultSet.getString("firstname");
                String role = resultSet.getString("role");
                String mail = resultSet.getString("mail");
                currentUser = new User(id, login, password, lastName, firstName, role, mail);
            }
            resultSet.close();
            return currentUser;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    return null;
    }
}


