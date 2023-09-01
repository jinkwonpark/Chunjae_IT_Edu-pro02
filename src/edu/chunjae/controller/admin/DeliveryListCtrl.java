package edu.chunjae.controller.admin;

import edu.chunjae.dto.Delivery;
import edu.chunjae.model.DeliveryDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/DeliveryList.do")
public class DeliveryListCtrl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(!sid.equals("admin") || sid==null){
            response.sendRedirect(request.getContextPath());
        }

        DeliveryDAO dao = new DeliveryDAO();
        List<Delivery> delList = dao.getDeliveryList();
        request.setAttribute("delList", delList);

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/delList.jsp");
        view.forward(request, response);
    }
}
