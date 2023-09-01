package edu.chunjae.controller.admin;

import edu.chunjae.dto.Delivery;
import edu.chunjae.model.DeliveryDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/SurveyDelivery.do")
public class SurveyDeliveryCtrl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(!sid.equals("admin") || sid==null){
            response.sendRedirect(request.getContextPath());
        }

        Delivery del = new Delivery();

        del.setDno(Integer.parseInt(request.getParameter("dno")));
        del.setPcom(request.getParameter("pcom"));
        del.setPtel(request.getParameter("ptel"));
        del.setSdate(request.getParameter("sdate"));
        del.setRdate(request.getParameter("rdate"));
        del.setBcode(request.getParameter("bcode"));

        DeliveryDAO dao = new DeliveryDAO();
        int cnt = dao.deliveryPro(del);
        response.sendRedirect(request.getContextPath()+"/AdminDelivery.do?dno="+request.getParameter("dno"));
    }
}
