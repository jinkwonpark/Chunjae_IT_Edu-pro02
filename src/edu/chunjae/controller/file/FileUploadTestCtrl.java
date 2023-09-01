package edu.chunjae.controller.file;

import com.sun.jna.platform.win32.COM.Dispatch;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/FileUploadTest.do")
public class FileUploadTestCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "파일을 업로드 합니다.";

        request.setAttribute("msg", msg);
        RequestDispatcher view = request.getRequestDispatcher("/filetest/fileupload.jsp");
        view.forward(request, response);
    }
}
