package edu.chunjae.controller.product;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import edu.chunjae.dto.Product;
import edu.chunjae.model.ProductDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

//상품 등록
@WebServlet("/AddProductPro.do")
public class AddProductProCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "";
        ServletContext application = request.getServletContext();
        String home = application.getContextPath();
        try {
            String saveDirectory = application.getRealPath("/storage"); //실제 저장 경로
            int maxSize = 1024*1024*10;     //10MB
            String encoding = "UTF-8";

            MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxSize, encoding, new DefaultFileRenamePolicy());
            Product pro = new Product();
            pro.setCate(mr.getParameter("cate"));
            pro.setPname(mr.getParameter("pname"));
            pro.setPcomment(mr.getParameter("pcomment"));
            pro.setPlist(mr.getParameter("plist"));
            pro.setPrice(Integer.parseInt(mr.getParameter("price")));

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
                            pro.setImgSrc3(upfile.getName());
                        } else if(idx==2){
                            pro.setImgSrc2(upfile.getName());
                        } else if(idx==3){
                            pro.setImgSrc1(upfile.getName());
                        }
                        msg = "파일 업로드 성공";
                    } else {
                        msg = "파일 업로드 실패";
                    }
                }
                idx++;
            }

            ProductDAO dao = new ProductDAO();
            int cnt = dao.addProduct(pro);
            if(cnt>0){
                response.sendRedirect(home+"/ProList.do");
            } else {
                response.sendRedirect(home+"/AddProduct.do");
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
