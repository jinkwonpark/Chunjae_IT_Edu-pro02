package edu.chunjae.controller.custom;

import edu.chunjae.dto.Custom;
import edu.chunjae.model.CustomDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/MyinfoUpdate.do")
public class MyinfoUpdateCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getParameter("id");

        CustomDAO dao = new CustomDAO();
        Custom cus = dao.getCustom(id);

        request.setAttribute("cus", cus);
        RequestDispatcher view = request.getRequestDispatcher("/custom/myinfoUpdate.jsp");
        view.forward(request, response);
    }
}