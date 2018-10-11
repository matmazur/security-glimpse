package controllers;

import beans.SecuredBean;

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
    SecuredBean securedBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Principal principal = req.getUserPrincipal();
        String name = principal.getName();

        resp.getWriter().println("secured area, hello " + name);
        try {
            String msg = securedBean.getMessage();
            resp.getWriter().println(msg);

        } catch (EJBAccessException e) {
            resp.getWriter().println("You need to be at least admin to see the msg");
        }
    }
}
