package edu.chunjae.model;

import edu.chunjae.dto.Category;
import edu.chunjae.dto.Notice;
import edu.chunjae.dto.Product;
import edu.chunjae.dto.Receive;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    String sql = "";

    public List<Product> getProductList(){
        List<Product> proList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_SELECT_ALL);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Product pro = new Product();
                pro.setPno(rs.getInt("pno"));
                pro.setCate(rs.getString("cate"));
                pro.setProno(rs.getString("prono"));
                pro.setPname(rs.getString("pname"));
                pro.setPcomment(rs.getString("pcomment"));
                pro.setPlist(rs.getString("plist"));
                pro.setPrice(rs.getInt("price"));
                pro.setImgSrc1(rs.getString("imgsrc1"));
                pro.setImgSrc2(rs.getString("imgsrc2"));
                pro.setImgSrc3(rs.getString("imgsrc3"));
                pro.setResdate(rs.getString("resdate"));
                proList.add(pro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return proList;
    }

    public List<Product> getNewProductList(){
        List<Product> proList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_SELECT_NEW);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Product pro = new Product();
                pro.setPno(rs.getInt("pno"));
                pro.setCate(rs.getString("cate"));
                pro.setProno(rs.getString("prono"));
                pro.setPname(rs.getString("pname"));
                pro.setPcomment(rs.getString("pcomment"));
                pro.setPlist(rs.getString("plist"));
                pro.setPrice(rs.getInt("price"));
                pro.setImgSrc1(rs.getString("imgsrc1"));
                pro.setImgSrc2(rs.getString("imgsrc2"));
                pro.setImgSrc3(rs.getString("imgsrc3"));
                pro.setResdate(rs.getString("resdate"));
                proList.add(pro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return proList;
    }

    public List<Product> getBestProductList(){
        List<Product> proList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_SELECT_BEST);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Product pro = new Product();
                pro.setPno(rs.getInt("pno"));
                pro.setCate(rs.getString("cate"));
                pro.setProno(rs.getString("prono"));
                pro.setPname(rs.getString("pname"));
                pro.setPcomment(rs.getString("pcomment"));
                pro.setPlist(rs.getString("plist"));
                pro.setPrice(rs.getInt("price"));
                pro.setImgSrc1(rs.getString("imgsrc1"));
                pro.setImgSrc2(rs.getString("imgsrc2"));
                pro.setImgSrc3(rs.getString("imgsrc3"));
                pro.setResdate(rs.getString("resdate"));
                proList.add(pro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return proList;
    }

    public List<Product> getCateProductList(String cate){
        List<Product> proList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_SELECT_CATE);
            pstmt.setString(1, cate);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Product pro = new Product();
                pro.setPno(rs.getInt("pno"));
                pro.setCate(rs.getString("cate"));
                pro.setProno(rs.getString("prono"));
                pro.setPname(rs.getString("pname"));
                pro.setPcomment(rs.getString("pcomment"));
                pro.setPlist(rs.getString("plist"));
                pro.setPrice(rs.getInt("price"));
                pro.setImgSrc1(rs.getString("imgsrc1"));
                pro.setImgSrc2(rs.getString("imgsrc2"));
                pro.setImgSrc3(rs.getString("imgsrc3"));
                pro.setResdate(rs.getString("resdate"));
                proList.add(pro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return proList;
    }

    public Product getProduct(int pno){
        Product pro = new Product();
        DBConnect con = new PostgreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_SELECT_ONE);
            pstmt.setInt(1, pno);
            rs = pstmt.executeQuery();
            if(rs.next()){
                pro.setPno(rs.getInt("pno"));
                pro.setCate(rs.getString("cate"));
                pro.setProno(rs.getString("prono"));
                pro.setPname(rs.getString("pname"));
                pro.setPcomment(rs.getString("pcomment"));
                pro.setPlist(rs.getString("plist"));
                pro.setPrice(rs.getInt("price"));
                pro.setImgSrc1(rs.getString("imgsrc1"));
                pro.setImgSrc2(rs.getString("imgsrc2"));
                pro.setImgSrc3(rs.getString("imgsrc3"));
                pro.setResdate(rs.getString("resdate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return pro;
    }

    public int addProduct(Product pro){
        int cnt =0;
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_INSERT);
            pstmt.setString(1, pro.getCate());
            pstmt.setString(2, pro.getPname());
            pstmt.setString(3, pro.getPcomment());
            pstmt.setString(4, pro.getPlist());
            pstmt.setInt(5, pro.getPrice());
            pstmt.setString(6, pro.getImgSrc1());
            pstmt.setString(7, pro.getImgSrc2());
            pstmt.setString(8, pro.getImgSrc3());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }

        con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_INSERT_UPDATE);
            cnt = cnt + pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int updateProduct(Product pro){
        int cnt =0;
        DBConnect con = new PostgreCon();
        conn = con.connect();

        try {
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_UPDATE);
            pstmt.setString(1, pro.getPname());
            pstmt.setString(2, pro.getPcomment());
            pstmt.setString(3, pro.getPlist());
            pstmt.setInt(4, pro.getPrice());
            pstmt.setString(5, pro.getImgSrc1());
            pstmt.setString(6, pro.getImgSrc2());
            pstmt.setString(7, pro.getImgSrc3());
            pstmt.setInt(8, pro.getPno());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int delProduct(int pno){
        int cnt =0;
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_DELETE);
            pstmt.setInt(1, pno);
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public List<Category> getCategoryList(){
        List<Category> cateList = new ArrayList<Category>();
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.CATEGORY_LOAD);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Category cate = new Category();
                cate.setCno(rs.getString("cno"));
                cate.setCname(rs.getString("cname"));
                cateList.add(cate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cateList;
    }

    public int getAmount(int pno){
        int amount = 0;
        DBConnect con = new PostgreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.INVENTORY_SELECT_ONE);
            pstmt.setInt(1, pno);
            rs = pstmt.executeQuery();
            if(rs.next()){
                amount = rs.getInt("amount");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return amount;
    }

    public int addReceive(Receive rec){
        int cnt = 0;
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.RECEIVE_INSERT);
            pstmt.setInt(1, rec.getPno());
            pstmt.setInt(2, rec.getAmount());
            pstmt.setInt(3, rec.getRprice());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }
}