package edu.chunjae.controller.payment;

import edu.chunjae.dto.Custom;
import edu.chunjae.dto.Notice;
import edu.chunjae.dto.Product;
import edu.chunjae.model.CustomDAO;
import edu.chunjae.model.NoticeDAO;
import edu.chunjae.model.ProductDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddPayment.do")
public class AddPaymentCtrl extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int pno = Integer.parseInt(request.getParameter("pno"));
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String cid = (String) session.getAttribute("sid");

        ProductDAO dao = new ProductDAO();
        Product pro = dao.getProduct(pno);
        int amount = dao.getAmount(pno);

        CustomDAO cusDao = new CustomDAO();
        Custom cus = cusDao.getCustom(cid);

        String from = "";
        if(request.getParameter("from")==""){
            from = "pro";
        } else {
            from = request.getParameter("from");
        }

        request.setAttribute("pro", pro);
        request.setAttribute("amount", amount);
        request.setAttribute("cus", cus);
        request.setAttribute("from", from);
        if(pro!=null) {
            RequestDispatcher view = request.getRequestDispatcher("/payment/addPayment.jsp");
            view.forward(request, response);
        } else {
            //request.sendRedirect("/AddNotice.do");
            out.println("<script>history.go(-1);</script>");
        }
    }
}
