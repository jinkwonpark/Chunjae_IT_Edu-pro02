package edu.chunjae.controller.product;

import edu.chunjae.dto.Product;
import edu.chunjae.model.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CateProList.do")
public class CateProListCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "상품 리스트를 출력합니다.");

        String cate = "";

        ProductDAO dao = new ProductDAO();
        List<Product> proList;

        if(request.getParameter("cate")==""){
            proList = dao.getProductList();
        } else {
            cate = request.getParameter("cate");
            proList = dao.getCateProductList(cate);
        }

        request.setAttribute("proList", proList);
        RequestDispatcher view = request.getRequestDispatcher("/product/proList.jsp");
        view.forward(request, response);
    }
}
