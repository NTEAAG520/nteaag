package dao;


import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public User findByUserName(String userName) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username=?");
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setGender(resultSet.getString("gender"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            DBUtil.close(connection);
        }
        return user;
    }

    public boolean save(User user) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO user VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getName());
            preparedStatement.setString(5, user.getGender());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            DBUtil.close(connection);
        }
        return true;
    }
}
