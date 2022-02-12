package com.example.andersen01;

public class Constants {
    public static final String INSERT = "INSERT INTO users (surname, name, age) VALUES (?, ?, ?);";
    public static final String GET_BY_ID = "SELECT * FROM users WHERE id = ?;";
    public static final String SELECT_ALL = "SELECT * FROM users;";
    public static final String UPDATE = "UPDATE users SET surname = ?, name = ?, age = ? WHERE id = ?;";
    public static final String DELETE = "DELETE FROM users WHERE id = ?;";
    public static final String POSTGRES_CLASS = "org.postgresql.Driver";
    public static final String POSTGRES_URL = "jdbc:postgresql://192.168.56.106:5432/yaminov?user=postgres&password=qwerty";
    public static final String ID = "id";
    public static final String SURNAME = "surname";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String JSP_USER_LIST = "src/main/webapp/user-list.jsp";
    public static final String JSP_USER_FORM = "src/main/webapp/user-form.jsp";
}
