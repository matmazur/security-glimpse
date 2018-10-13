package controllers;

import beans.UserRepository;
import model.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Inject
    private UserRepository userRepository;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        User user = null;

        if (userRepository.findUserByUsername(login).get(0) != null) {
            user = userRepository.findUserByUsername(login).get(0);
        }
        if (user != null && user.getPassword().equals(pass)) {

            response.getWriter().println("This is secured area, welcome " + user.getUsername());

            if (user.getRoles().contains("admin")) {
                response.getWriter().println("Secured Message no. " + System.currentTimeMillis());
            } else {
                response.getWriter().println("Sorry, you are not allowed to show secret message");
            }
        } else response.sendRedirect("failed.html");
    }
}
