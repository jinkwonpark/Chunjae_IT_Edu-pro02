package edu.chunjae.controller.admin;

import edu.chunjae.model.CustomDAO;
import edu.chunjae.model.DeliveryDAO;
import edu.chunjae.dto.*;
import edu.chunjae.model.PaymentDAO;
import edu.chunjae.model.ProductDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AdminDelivery.do")
public class AdminDeliveryCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(!sid.equals("admin") || sid==null){
            response.sendRedirect(request.getContextPath());
        }

        int dno = Integer.parseInt(request.getParameter("dno"));
        DeliveryDAO dao = new DeliveryDAO();
        Delivery del = dao.getDelivery(dno);

        Date sdate = new Date();
        Date rdate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sdate = sdf.parse(del.getSdate());
            del.setSdate(sdf.format(sdate));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        if(del.getRdate()!=null) {
            try {
                rdate = sdf.parse(del.getRdate());
                del.setRdate(sdf.format(rdate));
            } catch (ParseException e) {
                del.setRdate(sdf.format(new Date()));
                System.out.println(e.getMessage());
            }
        } else {
            del.setRdate(sdf.format(new Date()));
        }

        CustomDAO cusDAO = new CustomDAO();
        Custom cus = cusDAO.getCustom(del.getCid());

        PaymentDAO payDAO = new PaymentDAO();
        Payment pay = payDAO.getPayment(del.getSno());

        ProductDAO proDAO = new ProductDAO();
        Product pro = proDAO.getProduct(pay.getPno());

        request.setAttribute("pay", pay);
        request.setAttribute("pro", pro);
        request.setAttribute("cus", cus);
        request.setAttribute("del", del);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/getDelivery.jsp");
        view.forward(request, response);
    }
}
