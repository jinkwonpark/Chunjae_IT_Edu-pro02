package edu.chunjae.controller.admin;

import edu.chunjae.dto.Review;
import edu.chunjae.model.ReviewDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/AdminReviewList.do")
public class AdminReviewListCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(!sid.equals("admin") || sid==null){
            response.sendRedirect(request.getContextPath());
        }

        ReviewDAO revDAO = new ReviewDAO();
        List<Review> revList = revDAO.reviewList();

        request.setAttribute("revList", revList);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/adminReviewList.jsp");
        view.forward(request, response);
    }
}
