package edu.chunjae.controller.api;

import edu.chunjae.dto.Test;
import edu.chunjae.model.TestDAO;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@WebServlet("/Api4")
public class Api4Ctrl extends HttpServlet {
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

        PrintWriter out = response.getWriter();
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", data);

        JSONObject json = new JSONObject();
        json.putAll(map);       //List => Array
        out.println(json.toString());
    }
}