package edu.chunjae.model;

import edu.chunjae.dto.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    String sql = "";

    public Test getTest(int no){
        Test test = new Test();
        DBConnect con = new PostgreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.TEST_SELECT_ONE);
            pstmt.setInt(1, no);
            rs = pstmt.executeQuery();
            if(rs.next()){
                test.setNo(rs.getInt("no"));
                test.setName(rs.getString("name"));
                test.setPoint(rs.getInt("point"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return test;
    }

    public List<Test> getTestList(){
        List<Test> testList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.TEST_SELECT_ALL);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Test test = new Test();
                test.setNo(rs.getInt("no"));
                test.setName(rs.getString("name"));
                test.setPoint(rs.getInt("point"));
                testList.add(test);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return testList;
    }
}
