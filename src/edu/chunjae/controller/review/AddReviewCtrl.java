package edu.chunjae.controller.review;

import edu.chunjae.dto.Custom;
import edu.chunjae.dto.Delivery;
import edu.chunjae.dto.Payment;
import edu.chunjae.dto.Product;
import edu.chunjae.model.CustomDAO;
import edu.chunjae.model.DeliveryDAO;
import edu.chunjae.model.PaymentDAO;
import edu.chunjae.model.ProductDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/AddReview.do")
public class AddReviewCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sno = Integer.parseInt(request.getParameter("sno"));

        PaymentDAO payDAO = new PaymentDAO();
        Payment pay = payDAO.getPayment(sno);

        DeliveryDAO delDAO = new DeliveryDAO();
        Delivery del = delDAO.getBySnoDelivery(pay.getSno());

        ProductDAO proDAO = new ProductDAO();
        Product pro = proDAO.getProduct(pay.getPno());

        CustomDAO cusDAO = new CustomDAO();
        Custom cus = cusDAO.getCustom(pay.getCid());

        request.setAttribute("pay", pay);
        request.setAttribute("pro", pro);
        request.setAttribute("cus", cus);
        request.setAttribute("del", del);
        RequestDispatcher view = request.getRequestDispatcher("/review/addReview.jsp");
        view.forward(request, response);
    }
}
