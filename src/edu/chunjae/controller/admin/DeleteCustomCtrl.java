package edu.chunjae.controller.admin;

import edu.chunjae.model.CustomDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteCustom.do")
public class DeleteCustomCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(!sid.equals("admin") || sid==null){
            response.sendRedirect(request.getContextPath());
        }

        String[] custs = request.getParameterValues("id");

        CustomDAO dao = new CustomDAO();
        int cnt = 0;
        for(String id:custs){
            cnt = cnt + dao.deleteCustom(id);
        }

        String msg = cnt + "명이 탈퇴처리 되었습니다.";
        PrintWriter out = response.getWriter();

        if(cnt>0){
            response.sendRedirect("/AdminCustomList.do");
        } else {
            out.println("<script>history.go(-1);</script>");
        }
    }
}
