package edu.chunjae.model;

import edu.chunjae.dto.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {
    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    String sql = "";

    public int addReview(Review rev){
        int cnt = 0;
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.REVIEW_INSERT);
            pstmt.setInt(1, rev.getSno());
            pstmt.setString(2, rev.getCid());
            pstmt.setString(3, rev.getContent());
            pstmt.setInt(4, rev.getStar());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int delReview(int rno){
        int cnt = 0;
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.REVIEW_DELETE);
            pstmt.setInt(1, rno);
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public List<Review> reviewList(){
        List<Review> revList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.REVIEW_SELECT_LIST);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Review rev = new Review();
                rev.setRno(rs.getInt("rno"));
                rev.setSno(rs.getInt("sno"));
                rev.setCid(rs.getString("cid"));
                rev.setContent(rs.getString("content"));
                rev.setStar(rs.getInt("star"));
                rev.setResdate(rs.getString("resdate"));
                revList.add(rev);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return revList;
    }

    public List<Review> reviewList(int pno){
        List<Review> revList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.REVIEW_SELECT_PNO);
            pstmt.setInt(1, pno);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Review rev = new Review();
                rev.setRno(rs.getInt("rno"));
                rev.setSno(rs.getInt("sno"));
                rev.setCid(rs.getString("cid"));
                rev.setContent(rs.getString("content"));
                rev.setStar(rs.getInt("star"));
                rev.setResdate(rs.getString("resdate"));
                revList.add(rev);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return revList;
    }


}
