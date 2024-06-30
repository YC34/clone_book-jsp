package ch10;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {
    final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    final String JDBC_URL ="jdbc:oracle:thin:@118.220.40.170:1521:xe";



    public Connection open(){
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(JDBC_URL,"board","board");
        }catch (Exception e){
            System.out.println("ERROR : "+e.getMessage());
            throw new RuntimeException(e);
        }
        return conn;
    }


    public void addNews(News n) throws Exception{
        Connection conn = open();

        String sql = "insert into news(title,img,NEWS_DATE,content) values(?,?,sysdate,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // try-with-resource문
        try(conn; pstmt){
            System.out.println("img src : "+n.getImg());
            pstmt.setString(1, n.getTitle());
            pstmt.setString(2, n.getImg());
            pstmt.setString(3, n.getContent());
            pstmt.executeUpdate();
        }
    }


    public List<News> getAll() throws Exception{
        Connection conn = open();
        List<News> newsList = new ArrayList<News>();

        String sql = "select aid,title, news_date as cdate from news";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        try(conn;pstmt;rs){
            while(rs.next()){
                News n = new News();
                System.out.println(rs.getInt("aid"));
                n.setAid(rs.getInt("aid"));
                n.setTitle(rs.getString("title"));
                n.setDate(rs.getString("cdate"));
                newsList.add(n);
            }
            return newsList;
        }
    }



    public News getNews(int aid) throws SQLException {
        Connection conn = open();
        News n = new News();
        String sql = "select aid, title, img, news_date as cdate , content from news where aid = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, aid);
        ResultSet rs = pstmt.executeQuery();

        if(!rs.next()){
            throw new SQLException("aid가 잘못되었습니다.");
        }else {
            try(conn;pstmt;rs){
                n.setAid(rs.getInt("aid"));
                n.setTitle(rs.getString("title"));
                n.setImg(rs.getString("img"));
                n.setDate(rs.getString("cdate"));
                n.setContent(rs.getString("content"));
                pstmt.executeQuery();
                return n;
            }
        }
    }


    public void delNews(int aid) throws SQLException {
        Connection conn = open();
        String sql = "delete from news where aid = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        try(conn;pstmt;){
            pstmt.setInt(1, aid);
            if(pstmt.executeUpdate()==0){
                throw new SQLException("DB 에러");
            }
        }




    }
}
