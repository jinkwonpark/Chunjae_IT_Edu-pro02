package edu.chunjae.controller.admin;

import edu.chunjae.dto.Custom;
import edu.chunjae.dto.Delivery;
import edu.chunjae.dto.Payment;
import edu.chunjae.dto.Product;
import edu.chunjae.model.CustomDAO;
import edu.chunjae.model.DeliveryDAO;
import edu.chunjae.model.PaymentDAO;
import edu.chunjae.model.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AdminPayment.do")
public class AdminPaymentCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sno = Integer.parseInt(request.getParameter("sno"));

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(!sid.equals("admin")){
            response.sendRedirect(request.getContextPath());
        }

        PaymentDAO payDAO = new PaymentDAO();
        Payment pay = payDAO.getPayment(sno);

        DeliveryDAO delDAO = new DeliveryDAO();
        Delivery del = delDAO.getDelivery(pay.getSno());

        ProductDAO proDAO = new ProductDAO();
        Product pro = proDAO.getProduct(pay.getPno());

        CustomDAO cusDAO = new CustomDAO();
        Custom cus = cusDAO.getCustom(pay.getCid());

        request.setAttribute("pay", pay);
        request.setAttribute("pro", pro);
        request.setAttribute("cus", cus);
        request.setAttribute("del", del);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/getAdminPayment.jsp");
        view.forward(request, response);
    }
}
