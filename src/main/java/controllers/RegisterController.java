package controllers;

import beans.UserRepository;
import com.google.common.hash.Hashing;
import model.User;
import utils.Salt;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    @Inject
    UserRepository repository;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        User user = new User(username, Salt.saltAndHash(password), role);
        repository.add(user);
        resp.sendRedirect(req.getContextPath());

    }
}
