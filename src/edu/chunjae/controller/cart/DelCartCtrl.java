package edu.chunjae.controller.cart;

import edu.chunjae.model.CartDAO;
import edu.chunjae.model.CustomDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DelCart.do")
public class DelCartCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] cartno = request.getParameterValues("cartno");

        CartDAO dao = new CartDAO();
        int cnt = 0;

        for(String cn:cartno) {
            int cno = Integer.parseInt(cn);
            cnt = cnt + dao.delCart(cno);
        }

        PrintWriter out = response.getWriter();

        if(cnt>0){
            response.sendRedirect(request.getContextPath()+"/CartList.do");
        } else {
            out.println("<script>history.go(-1);</script>");
        }
    }
}
