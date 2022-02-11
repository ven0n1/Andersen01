package com.example.andersen01.dataprovider;

import com.example.andersen01.model.User;

import java.util.List;

public interface IDataProvider {
    boolean insert(User user);
    User getById(int id);
    List<User> selectAll();
    boolean update(User user);
    boolean delete(User user);
}
