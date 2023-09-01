package edu.chunjae.controller.product;

import edu.chunjae.dto.Product;
import edu.chunjae.model.ProductDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ProList.do")
public class ProListCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "상품 리스트를 출력합니다.");

        ProductDAO dao = new ProductDAO();
        List<Product> proList = dao.getProductList();

        request.setAttribute("proList", proList);
        RequestDispatcher view = request.getRequestDispatcher("/product/proList.jsp");
        view.forward(request, response);
    }
}
