package edu.chunjae.controller.payment;

import edu.chunjae.dto.Payment;
import edu.chunjae.dto.PaymentVO;
import edu.chunjae.model.PaymentDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/PaymentList.do")
public class PaymentListCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cid = (String) session.getAttribute("sid");

        PaymentDAO payDAO = new PaymentDAO();
        List<PaymentVO> payList = payDAO.getCidPaymentList(cid);

        request.setAttribute("payList", payList);
        RequestDispatcher view = request.getRequestDispatcher("/payment/paymentList.jsp");
        view.forward(request, response);
    }
}
