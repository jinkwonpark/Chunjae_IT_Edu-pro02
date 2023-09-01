package edu.chunjae.controller.admin;

import edu.chunjae.model.DeliveryDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/CompleteDelivery.do")
public class CompleteDeliveryCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(!sid.equals("admin") || sid==null){
            response.sendRedirect(request.getContextPath());
        }

        int dno = Integer.parseInt(request.getParameter("dno"));
        DeliveryDAO dao = new DeliveryDAO();
        int cnt = dao.deliveryComplete(dno);

        response.sendRedirect(request.getContextPath()+"/AdminDelivery.do?dno="+request.getParameter("dno"));
    }
}
