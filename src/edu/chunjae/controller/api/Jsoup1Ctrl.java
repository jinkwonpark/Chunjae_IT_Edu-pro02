package edu.chunjae.controller.api;

import edu.chunjae.dto.News;
import edu.chunjae.util.Crawler;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Jsoup1")
public class Jsoup1Ctrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        Crawler cr = new Crawler();
        List<News> newsList = cr.getNews();

        request.setAttribute("newsList", newsList);
        PrintWriter out = response.getWriter();
        RequestDispatcher view = request.getRequestDispatcher("/test/jsouptest.jsp");
        view.forward(request, response);
    }
}
