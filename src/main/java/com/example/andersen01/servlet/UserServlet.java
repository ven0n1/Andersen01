package com.example.andersen01.servlet;

import com.example.andersen01.Constants;
import com.example.andersen01.dataprovider.IDataProvider;
import com.example.andersen01.dataprovider.PostgresDataProvider;
import com.example.andersen01.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private IDataProvider dataProvider;

    @Override
    public void init() {
        dataProvider = new PostgresDataProvider();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertUser(request, response);
                break;
            case "/delete":
                deleteUser(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateUser(request, response);
                break;
            default:
                selectAll(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<User> listUser = dataProvider.selectAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher(Constants.JSP_USER_LIST);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(Constants.JSP_USER_FORM);
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(Constants.ID));
        User existingUser = dataProvider.getById(id);
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher(Constants.JSP_USER_FORM);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        User user = new User(request.getParameter(Constants.SURNAME), request.getParameter(Constants.NAME),
                Integer.parseInt(request.getParameter(Constants.AGE)));
        dataProvider.insert(user);
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter(Constants.ID));
        User user = new User(id, request.getParameter(Constants.SURNAME), request.getParameter(Constants.NAME),
                Integer.parseInt(request.getParameter(Constants.AGE)));
        dataProvider.update(user);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter(Constants.ID));
        dataProvider.delete(id);
        response.sendRedirect("list");

    }
}
