package edu.chunjae.controller.admin;

import edu.chunjae.dto.Review;
import edu.chunjae.model.ReviewDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/DelReview.do")
public class DelReviewCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(!sid.equals("admin") || sid==null){
            response.sendRedirect(request.getContextPath());
        }

        int rno = Integer.parseInt(request.getParameter("rno"));

        ReviewDAO revDAO = new ReviewDAO();
        int cnt = revDAO.delReview(rno);
        response.sendRedirect(request.getContextPath()+"/AdminReviewList.do");
    }
}
