package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
    static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=heng_supermarket";
    static String userName="sa";
    static String userPwd="zhangheng0.0123";

    public static Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName(driverName);
            conn=DriverManager.getConnection(dbURL, userName,userPwd);
            System.out.println("succeed");
        } catch (Exception e) {
            System.out.println("failed");
            e.printStackTrace();
        }
        return conn;
    }
    public static boolean executeUpdate(String sql,Object[] objs){
        boolean flag=false;
        Connection conn=getConnection();
        PreparedStatement pst=null;
        try {
            pst=conn.prepareStatement(sql);
            for(int i=0;i<objs.length;i++){
                pst.setObject(i+1, objs[i]);
            }
            int num=pst.executeUpdate();
            if(num>0){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeAll(conn, pst, null);
        }

        return flag;
    }
    public static void closeAll(Connection conn,Statement stat,ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }
            if(stat!=null){
                stat.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
