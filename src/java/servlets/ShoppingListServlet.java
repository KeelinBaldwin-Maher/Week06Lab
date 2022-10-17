/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("username");

        String logout = request.getParameter("logout");

        if (username != null && !username.isEmpty() && logout == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

        } else if (logout != null && username != null) {
            username = null;
            session.invalidate();
            session = request.getSession();
            request.setAttribute("message", "Logout successful");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String action = request.getParameter("action");

        ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");

        switch (action) {
            case "register":
                String username = request.getParameter("username");
                if (username.isEmpty()) {
                    request.setAttribute("message", "Please enter a username");
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                } else {
                    session.setAttribute("username", username);
                }
                break;

            case "add":
                String addItem = request.getParameter("addListItem");

                if (list == null) {
                    list = new ArrayList<>();
                    list.add(addItem);
                } else {
                    list.add(addItem);
                }

                session.setAttribute("list", list);
                break;

            case "delete":
                String deleteItem = request.getParameter("deleteListItem");

                list.remove(deleteItem);
                session.setAttribute("list", list);
                break;

            default:
                System.out.println("default");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}
