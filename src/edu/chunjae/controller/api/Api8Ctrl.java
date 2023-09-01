package edu.chunjae.controller.api;

import com.google.gson.Gson;
import edu.chunjae.dto.Test;
import edu.chunjae.model.TestDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Api8")
public class Api8Ctrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        //CORS(Cross Origin Resource Sharing) 해제
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        TestDAO dao = new TestDAO();
        List<Test> data = dao.getTestList();

        String gson = new Gson().toJson(data);
        PrintWriter out = response.getWriter();
        out.println(gson);
        //out.write(gson);
    }
}
