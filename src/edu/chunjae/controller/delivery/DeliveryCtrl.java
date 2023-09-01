package edu.chunjae.controller.delivery;

import edu.chunjae.dto.Delivery;
import edu.chunjae.model.DeliveryDAO;
import edu.chunjae.model.PaymentDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Delivery.do")
public class DeliveryCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sno = Integer.parseInt(request.getParameter("sno"));
        DeliveryDAO dao = new DeliveryDAO();

        Delivery del = dao.getBySnoDelivery(sno);
        request.setAttribute("del", del);
        RequestDispatcher view = request.getRequestDispatcher("/payment/getDelivery.jsp");
        view.forward(request, response);
    }
}
