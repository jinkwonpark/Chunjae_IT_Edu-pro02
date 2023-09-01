package edu.chunjae.controller.admin;

import edu.chunjae.dto.Notice;
import edu.chunjae.model.NoticeDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateNoticePro.do")
public class UpdateNoticeProCtrl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(!sid.equals("admin") || sid==null){
            response.sendRedirect(request.getContextPath());
        }

        Notice noti = new Notice();
        noti.setNo(Integer.parseInt(request.getParameter("no")));
        noti.setTitle(request.getParameter("title"));
        noti.setContent(request.getParameter("content"));

        NoticeDAO dao = new NoticeDAO();
        int a = dao.updateNotice(noti);

        PrintWriter out = response.getWriter();

        if(a>0){
            response.sendRedirect(request.getContextPath()+"/NoticeList.do");
        } else {
            out.println("<script>history.go(-1);</script>");
        }
    }
}
