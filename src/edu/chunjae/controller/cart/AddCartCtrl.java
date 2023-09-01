package edu.chunjae.controller.cart;

import edu.chunjae.dto.Cart;
import edu.chunjae.model.CartDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddCart.do")
public class AddCartCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pno = Integer.parseInt(request.getParameter("pno"));
        HttpSession session = request.getSession();
        String cid = (String) session.getAttribute("sid");

        Cart cart = new Cart();
        cart.setPno(pno);
        cart.setCid(cid);
        cart.setAmount(1);

        CartDAO dao = new CartDAO();
        int cnt = dao.addCart(cart);

        PrintWriter out = response.getWriter();

        if(cnt>0){
            response.sendRedirect(request.getContextPath()+"/CartList.do");
        } else {
            out.println("<script>history.go(-1);</script>");
        }
    }
}
