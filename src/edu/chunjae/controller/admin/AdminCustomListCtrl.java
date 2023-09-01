package edu.chunjae.controller.admin;

import edu.chunjae.dto.Custom;
import edu.chunjae.dto.Notice;
import edu.chunjae.model.CustomDAO;
import edu.chunjae.model.NoticeDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/AdminCustomList.do")
public class AdminCustomListCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "회원 목록을 출력합니다.");

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(!sid.equals("admin") || sid==null){
            response.sendRedirect(request.getContextPath());
        }

        CustomDAO dao = new CustomDAO();
        List<Custom> cusList = dao.getCustomList();
        request.setAttribute("cusList", cusList);

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/customList.jsp");
        view.forward(request, response);
    }
}