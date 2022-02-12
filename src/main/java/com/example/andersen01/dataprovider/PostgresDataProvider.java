package com.example.andersen01.dataprovider;

import com.example.andersen01.Constants;
import com.example.andersen01.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresDataProvider implements IDataProvider{
    private static final Logger log = LogManager.getLogger(PostgresDataProvider.class);
    @Override
    public boolean insert(User user) {
        log.info("start insert");
        log.debug("start insert for user: " + user);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(Constants.INSERT)) {
            preparedStatement.setString(1, user.getSurname());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setInt(3, user.getAge());
        } catch (SQLException e) {
            log.error(e);
            return false;
        }
        log.info("insert successful");
        return true;
    }

    @Override
    public User getById(int id) {
        log.info("start insert");
        log.debug("start insert for user with id: " + id);
        User user = new User();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(Constants.GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            log.debug("created prepared statement: " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = new User(id, resultSet.getString(Constants.SURNAME), resultSet.getString(Constants.NAME), resultSet.getInt(Constants.AGE));
            }
        } catch (SQLException e) {
            log.error(e);
            return user;
        }
        log.info("getById successful");
        log.debug("getById successful. Found user: " + user);
        return user;
    }

    @Override
    public List<User> selectAll() {
        log.info("start selectAll");
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(Constants.SELECT_ALL)) {
            log.debug("created prepared statement: " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                users.add(new User(resultSet.getInt(Constants.ID), resultSet.getString(Constants.SURNAME),
                        resultSet.getString(Constants.NAME), resultSet.getInt(Constants.AGE)));
            }
            log.debug("size of users: " + users.size());
        } catch (SQLException e) {
            log.error(e);
            return users;
        }
        log.info("selectAll successful");
        return users;
    }

    @Override
    public boolean update(User user) {
        log.info("start update");
        log.debug("start update with user: " + user);
        boolean updated = false;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(Constants.UPDATE)) {
            preparedStatement.setString(1, user.getSurname());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setInt(4, user.getId());
            log.debug("created prepared statement: " + preparedStatement);
            updated = preparedStatement.executeUpdate() > 0;
            log.debug("updated status: " + updated);
        } catch (SQLException e) {
            log.error(e);
        }
        log.info("update successful");
        return updated;
    }

    @Override
    public boolean delete(int id) {
        boolean deleted = false;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(Constants.DELETE)) {
            preparedStatement.setInt(1, id);
            log.debug("created prepared statement: " + preparedStatement);
            deleted = preparedStatement.executeUpdate() > 0;
            log.debug("deleted status: " + deleted);
        } catch (SQLException e) {
            log.error(e);
        }
        return deleted;
    }

    private Connection getConnection() {
        log.info("start connection");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Constants.POSTGRES_URL);
        } catch (SQLException e) {
            log.error(e);
        }
        log.info("connection successful");
        return connection;
    }
}
