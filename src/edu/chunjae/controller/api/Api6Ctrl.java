package edu.chunjae.controller.api;

import com.google.gson.Gson;
import edu.chunjae.dto.Test;
import edu.chunjae.model.TestDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Api6")
public class Api6Ctrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        //CORS(Cross Origin Resource Sharing) 해제
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        int no = Integer.parseInt(request.getParameter("no"));

        TestDAO dao = new TestDAO();
        Test result = dao.getTest(no);

        String gson = new Gson().toJson(result);
        PrintWriter out = response.getWriter();
        out.write(gson);
    }
}
