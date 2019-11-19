package edu.mum.cs.cs472.service.impl;

import edu.mum.cs.cs472.dao.User;
import edu.mum.cs.cs472.service.UserService;
import edu.mum.cs.cs472.util.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private DBConnection dbConnection;

    @Override
    public List<User> getAllUser() {
        System.out.println("Get All Users");
        String queryString = "select first_name from users";

        List<User> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.getDbConnection().getConnection().prepareStatement(queryString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new User());
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.getDbConnection().disconnect();
        }
        System.out.println(list);
        return list;
    }


    public String registerUser(User userData){
        System.out.println("UserServiceImp.registeruser" + userData.toString());
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into fos.users(first_name, email, password) values (?,?,?)");
            pstmt.setString(1, userData.getFirst_name());
            pstmt.setString(2, userData.getEmail());
            pstmt.setString(3, userData.getPassword());
            int i= pstmt.executeUpdate();
            if (i!=0)
                return "SUCCESS";
        }catch(SQLException e) {
            System.err.println(e);
        }
        return "Oops.. Something went wrong there..!";
    }

    @Override
    public List<User> getUserById(int userId) {
        return null;
    }

    @Override
    public User login() {
        return null;
    }

    @Override
    public void logout() {

    }

    public DBConnection getDbConnection() {
        return dbConnection != null ? this.dbConnection : (this.dbConnection = new DBConnection());
    }

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
}
