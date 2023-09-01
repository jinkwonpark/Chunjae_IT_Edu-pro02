package edu.chunjae.controller.custom;

import edu.chunjae.dto.Custom;
import edu.chunjae.model.CustomDAO;
import edu.chunjae.util.AES256;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/MyinfoUpdatePro.do")
public class MyinfoUpdateProCtrl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");

        boolean result = false;
        int suc = 0;

        String key = "%02x";
        String encrypted = "";
        try {
            encrypted = AES256.encryptAES256(pw, key);
            System.out.println("비밀번호 암호화 : "+encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }

        CustomDAO dao = new CustomDAO();
        Custom user = new Custom();

        user.setId(id);
        user.setPw(encrypted);
        user.setTel(tel);
        user.setEmail(email);
        suc = dao.updateCustom(user);

        if(suc>0){
            response.sendRedirect(request.getContextPath()+"Mypage.do?id="+id);
        } else {
            response.sendRedirect("/MyInfoUpdate.do?id="+id);
        }
    }
}
