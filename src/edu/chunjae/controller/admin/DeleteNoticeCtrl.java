package edu.chunjae.controller.admin;

import edu.chunjae.model.NoticeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteNoticeCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(!sid.equals("admin") || sid==null){
            response.sendRedirect(request.getContextPath());
        }

        int no = Integer.parseInt(request.getParameter("no"));

        NoticeDAO dao = new NoticeDAO();
        int a = dao.deleteNotice(no);

        PrintWriter out = response.getWriter();

        if(a>0){
            response.sendRedirect(request.getContextPath()+"/NoticeList.do");
        } else {
            out.println("<script>history.go(-1);</script>");
        }
    }
}
