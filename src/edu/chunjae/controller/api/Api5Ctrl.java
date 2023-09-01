package edu.chunjae.controller.api;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

@WebServlet("/Api5")
public class Api5Ctrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        //CORS(Cross Origin Resource Sharing) 해제
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String msg = "Hello~!";
        String gson = new Gson().toJson(msg);
        PrintWriter out = response.getWriter();
        out.write(gson);
    }
}
