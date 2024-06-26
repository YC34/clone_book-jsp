package ch09;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    final String JDBC_URL ="jdbc:oracle:thin:@118.220.40.170:1521:xe";

    /**
     * DB 연결
     */
    public void open(){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(JDBC_URL,"board","board");
        } catch (Exception e) {
            System.out.println("ERROR : " +e.getMessage());
            throw new RuntimeException(e);

        }

    }


    /**
     * DB 연결 닫기.
     */
    public void close(){
        try {
            pstmt.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("ERROR : "+e.getMessage());
            throw new RuntimeException(e);
        }
    }


    public void insert(Student s){
        open();
        String sql = "insert into student (USERNAME,UNIV,BIRTH,email) values(?,?,?,?)";
        try {
            pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,s.getUsername());
            pstmt.setString(2,s.getUniv());
            // Date의 type이 java의 Util type이므로 변경해줘야함.
            java.sql.Date sqlDate = new java.sql.Date(s.getBirth().getTime());
            pstmt.setDate(3,sqlDate);
            pstmt.setString(4,s.getEmail());

            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR : "+e.getMessage());
            throw new RuntimeException(e);
        }finally {
            close();
        }
    }


    public List<Student> getAll(){
        open();
        List<Student> students = new ArrayList<Student>();

        try {
            pstmt =conn.prepareStatement("select * from student");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setUsername(rs.getString("username"));
                s.setUniv(rs.getString("univ"));
                s.setBirth(rs.getDate("birth"));
                s.setEmail(rs.getString("email"));

                students.add(s);
            }
        }catch (Exception e){
            System.out.println("ERROR : "+e.getMessage());
            throw new RuntimeException(e);
        }finally {
            close();
        }
        return students;
    }

}
