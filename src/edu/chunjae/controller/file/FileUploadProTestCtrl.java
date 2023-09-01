package edu.chunjae.controller.file;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import edu.chunjae.dto.Filetest;
import edu.chunjae.model.FiletestDAO;

import javax.mail.Multipart;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/FileUploadProTest.do")
public class FileUploadProTestCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        String uname = request.getParameter("uname");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        String filename = request.getParameter("filename");
        */
        String msg = "";
        ServletContext application = request.getServletContext();
        try {
            String saveDirectory = application.getRealPath("/storage"); //실제 저장 경로
            int maxSize = 1024*1024*10;     //10MB
            String encoding = "UTF-8";

            MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxSize, encoding, new DefaultFileRenamePolicy());
            Filetest file = new Filetest();
            file.setUname(mr.getParameter("uname"));
            file.setSubject(mr.getParameter("subject"));
            file.setContent(mr.getParameter("content"));

            Enumeration files = mr.getFileNames();
            String item = (String) files.nextElement();

            String oriFile = mr.getOriginalFileName(item); //실제 첨부된 파일경로와 이름
            String fileName = mr.getFilesystemName(item);  //파일이름만 추출

            File upfile = mr.getFile(item); //실제 업로드
            if(upfile.exists()){
                msg = "파일 업로드 성공";
            } else {
                msg = "파일 업로드 실패";
            }

            file.setFilename(upfile.getName());

            FiletestDAO dao = new FiletestDAO();
            int cnt = dao.fileUploadTest(file);
            List<Filetest> fileList = new ArrayList<>();
            if(cnt>0){
              fileList = dao.getFileTestList();
              request.setAttribute("fileList",fileList);
              RequestDispatcher view = request.getRequestDispatcher("/filetest/filelist.jsp");
              view.forward(request, response);
            } else {
                response.sendRedirect("/FileUploadTest.do");
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
