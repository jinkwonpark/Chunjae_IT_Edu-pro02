package edu.chunjae.controller.notice;

import edu.chunjae.dto.Notice;
import edu.chunjae.model.NoticeDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Notice.do")
public class NoticeCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        NoticeDAO dao = new NoticeDAO();
        Notice noti = dao.getNotice(no);
        request.setAttribute("noti", noti);
        RequestDispatcher view = request.getRequestDispatcher("/notice/getNotice.jsp");
        view.forward(request, response);
    }
}
