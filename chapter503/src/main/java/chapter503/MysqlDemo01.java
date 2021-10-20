package chapter503;

import java.sql.*;

public class MysqlDemo01 {

    private static String url = "jdbc:mysql://localhost:3306/school?autoReconnect=true";
    private static String user = "root";
    private static String pwd = "simonzhang";

    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (null == con) {
            System.out.println("===get connection error===");
        }
        try {
            ps = con.prepareStatement("insert into class01 (id, name) values (1, 'student01')");
            int count = ps.executeUpdate();
            System.out.println("insert counts = " + count);

            ps = con.prepareStatement("select * from class01 where id = 1");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getObject("name"));
            }

            ps = con.prepareStatement("update class01 set name = 'student02' where id = 1");
            count = ps.executeUpdate();
            System.out.println("update counts = " + count);

            ps = con.prepareStatement("delete from class01 where id = 1");
            count = ps.executeUpdate();
            System.out.println("update counts = " + count);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != con) {
                    con.close();
                }
                if (null != ps) {
                    ps.close();
                }
                if (null != rs) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url,user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
