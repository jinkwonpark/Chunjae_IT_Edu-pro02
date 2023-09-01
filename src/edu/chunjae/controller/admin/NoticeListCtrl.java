package edu.chunjae.controller.admin;

import edu.chunjae.dto.Notice;
import edu.chunjae.model.NoticeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/AdminNoticeList.do")
public class NoticeListCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(!sid.equals("admin") || sid==null){
            response.sendRedirect(request.getContextPath());
        }

        request.setAttribute("msg", "공지사항 목록을 출력합니다.");

        NoticeDAO dao = new NoticeDAO();
        List<Notice> notiList = dao.getNoticeList();
        request.setAttribute("notiList", notiList);

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/noticeList.jsp");
        view.forward(request, response);
    }
}
