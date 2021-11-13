package chapter701;

import java.sql.*;

public class InsertBatch {

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
            System.out.println("Starting at: " + new Timestamp(System.currentTimeMillis()));

            Statement stmt = con.createStatement();

            int count = 0;
            do {
                String sql = "insert into class01 values (" + count + ", 'Student" + count + "')";
                //利用addBatch方法将SQL语句加入到stmt对象中
                stmt.addBatch(sql);
                if (count % 1000 == 0 && count != 0) {
                    //利用executeBatch方法执行1000条SQL语句
                    stmt.executeBatch();
                    stmt.clearBatch();
                    con.commit();
                }
            } while (++count < 10000);

            stmt.executeBatch();
            stmt.clearBatch();
            con.commit();

            System.out.println("Ending at: " + new Timestamp(System.currentTimeMillis()));

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
            con.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
