package com.example.andersen01.dataprovider;

import com.example.andersen01.model.User;

import java.util.List;

public class MySqlDataProvider implements IDataProvider{
    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }
}
