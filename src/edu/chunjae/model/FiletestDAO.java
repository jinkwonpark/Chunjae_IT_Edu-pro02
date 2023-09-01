package edu.chunjae.model;

import edu.chunjae.dto.Filetest;
import edu.chunjae.dto.Filetest2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FiletestDAO {
    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    public int fileUploadTest(Filetest file){
        int cnt = 0;
        DBConnect con = new PostgreCon();
        String sql = "insert into filetest values (?,?,?,?)";
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, file.getUname());
            pstmt.setString(2, file.getSubject());
            pstmt.setString(3, file.getContent());
            pstmt.setString(4, file.getFilename());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public List<Filetest> getFileTestList(){
        List<Filetest> fileList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        String sql = "select * from filetest";
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Filetest file = new Filetest();
                file.setUname(rs.getString("uname"));
                file.setSubject(rs.getString("subject"));
                file.setContent(rs.getString("content"));
                file.setFilename(rs.getString("filename"));
                fileList.add(file);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return fileList;
    }

    public int fileUploadTest2(Filetest2 file){
        int cnt = 0;
        DBConnect con = new PostgreCon();
        String sql = "insert into filetest2 values (?,?,?,?,?,?)";
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, file.getUname());
            pstmt.setString(2, file.getSubject());
            pstmt.setString(3, file.getContent());
            pstmt.setString(4, file.getFilename1());
            pstmt.setString(5, file.getFilename2());
            pstmt.setString(6, file.getFilename3());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public List<Filetest2> getFileTestList2(){
        List<Filetest2> fileList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        String sql = "select * from filetest2";
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Filetest2 file = new Filetest2();
                file.setUname(rs.getString("uname"));
                file.setSubject(rs.getString("subject"));
                file.setContent(rs.getString("content"));
                file.setFilename1(rs.getString("filename1"));
                file.setFilename2(rs.getString("filename2"));
                file.setFilename3(rs.getString("filename3"));
                fileList.add(file);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return fileList;
    }
}
