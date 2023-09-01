package edu.chunjae.controller.file;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import edu.chunjae.dto.Filetest;
import edu.chunjae.dto.Filetest2;
import edu.chunjae.model.FiletestDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/FileUploadProTest2.do")
public class FileUploadProTest2Ctrl extends HttpServlet {
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
            Filetest2 file2 = new Filetest2();
            file2.setUname(mr.getParameter("uname"));
            file2.setSubject(mr.getParameter("subject"));
            file2.setContent(mr.getParameter("content"));

            File upfile = null;
            Enumeration files = mr.getFileNames();

            int idx = 1;
            String item;
            String oriFile = "";
            String fileName = "";
            while(files.hasMoreElements()) {
                item = (String) files.nextElement();
                oriFile = mr.getOriginalFileName(item); //실제 첨부된 파일경로와 이름
                fileName = mr.getFilesystemName(item);  //파일이름만 추출
                if(fileName!=null) {
                    upfile = mr.getFile(item); //실제 업로드
                    if (upfile.exists()) {
                        long filesize = upfile.length();
                        if(idx==1) {
                            file2.setFilename3(upfile.getName());
                        } else if(idx==2){
                            file2.setFilename2(upfile.getName());
                        } else if(idx==3){
                            file2.setFilename1(upfile.getName());
                        }
                        msg = "파일 업로드 성공";
                    } else {
                        msg = "파일 업로드 실패";
                    }
                }
                idx++;
            }

            FiletestDAO dao = new FiletestDAO();
            int cnt = dao.fileUploadTest2(file2);
            List<Filetest2> fileList = new ArrayList<>();
            if(cnt>0){
              fileList = dao.getFileTestList2();
              request.setAttribute("fileList",fileList);
              RequestDispatcher view = request.getRequestDispatcher("/filetest/filelist2.jsp");
              view.forward(request, response);
            } else {
                response.sendRedirect("/FileUploadTest2.do");
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
