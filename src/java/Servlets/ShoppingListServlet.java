/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String username = (String) session.getAttribute("username");
        
        //String logout = (String) request.getAttribute("logout");
       // Boolean logout = (Boolean) session.getAttribute("logout");
        
        if (username != null  && !username.isEmpty() && logout == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            
        } else if (logout != null) {
            session.invalidate();
            request.setAttribute("message", "Logout successful");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            
                      
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            
        }
        
    }

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        
        boolean shoppingList = true;
        
        switch(action) {
            case "register":
                String username = request.getParameter("username");
                if(username.isEmpty()) {
                    request.setAttribute("message", "Please enter a username");
                    shoppingList = false;
                } else {
                    session.setAttribute("username", username);
                }
                break;
                
            case "logout":
                session.setAttribute("logout", true);
                shoppingList = false;
                break;
                
            default:
                System.out.println("default");
        }
        
        if (shoppingList) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else {
             getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
      
    }

}
