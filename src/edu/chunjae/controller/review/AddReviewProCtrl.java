package edu.chunjae.controller.review;

import edu.chunjae.dto.Review;
import edu.chunjae.model.ReviewDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddReviewPro.do")
public class AddReviewProCtrl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sno = Integer.parseInt(request.getParameter("sno"));
        String cid = request.getParameter("cid");
        String content = request.getParameter("content");
        int star = Integer.parseInt(request.getParameter("star"));

        Review rev = new Review();
        rev.setSno(sno);
        rev.setCid(cid);
        rev.setContent(content);
        rev.setStar(star);

        ReviewDAO dao = new ReviewDAO();
        int cnt = dao.addReview(rev);
        PrintWriter out = response.getWriter();

        response.sendRedirect(request.getContextPath());
    }
}
