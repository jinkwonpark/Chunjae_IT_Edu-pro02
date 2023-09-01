package edu.chunjae.controller.product;

import edu.chunjae.dto.Product;
import edu.chunjae.dto.Review;
import edu.chunjae.model.ProductDAO;
import edu.chunjae.model.ReviewDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/Product.do")  //Product.do?pno=${pro.pno}
public class ProductCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "상품 리스트를 출력합니다.");

        int pno = Integer.parseInt(request.getParameter("pno"));

        ProductDAO dao = new ProductDAO();
        Product pro = dao.getProduct(pno);
        int amount = dao.getAmount(pno);

        ReviewDAO revDAO = new ReviewDAO();
        List<Review> revList = revDAO.reviewList(pno);

        request.setAttribute("revList", revList);
        request.setAttribute("pro", pro);
        request.setAttribute("amount", amount);
        RequestDispatcher view = request.getRequestDispatcher("/product/getProduct.jsp");
        view.forward(request, response);
    }
}
