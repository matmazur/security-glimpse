package controllers;

import beans.SecuredBean;
import beans.UserRepository;
import model.User;

import javax.ejb.EJBAccessException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@WebServlet("/secure")
@ServletSecurity(
        @HttpConstraint(rolesAllowed = {"user", "admin"}))
public class SecuredController extends HttpServlet {

    @Inject
    UserRepository repository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        User user = new User(username,password,role);
        repository.add(user);
        resp.sendRedirect(req.getContextPath());

    }
}
