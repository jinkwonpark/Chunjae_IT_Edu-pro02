package edu.chunjae.controller.admin;

import edu.chunjae.dto.Notice;
import edu.chunjae.model.NoticeDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddNoticePro.do")
public class AddNoticeProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String title = request.getParameter("title");
        //String content = request.getParameter("content");

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(!sid.equals("admin") || sid==null){
            response.sendRedirect(request.getContextPath());
        }

        Notice noti = new Notice();
        //noti.setTitle(title);
        noti.setTitle(request.getParameter("title"));
        noti.setContent(request.getParameter("content"));

        PrintWriter out = response.getWriter();

        NoticeDAO dao = new NoticeDAO();
        int a = dao.addNotice(noti);
        if(a>0) {
            response.sendRedirect(request.getContextPath()+"/NoticeList.do");
        } else {
            //request.sendRedirect("/AddNotice.do");
            out.println("<script>history.go(-1);</script>");
        }
    }
}
