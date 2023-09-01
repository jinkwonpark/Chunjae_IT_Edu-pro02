package edu.chunjae.controller.admin;

import edu.chunjae.dto.PaymentVO;
import edu.chunjae.model.PaymentDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/AdminPaymentList.do")
public class AdminPaymentListCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(!sid.equals("admin") || sid==null){
            response.sendRedirect(request.getContextPath());
        }

        PaymentDAO payDAO = new PaymentDAO();
        List<PaymentVO> payList = payDAO.getPaymentList();

        request.setAttribute("payList", payList);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/adminPaymentList.jsp");
        view.forward(request, response);
    }
}
