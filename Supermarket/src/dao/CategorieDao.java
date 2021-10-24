package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategorieDao {
    public String getCategoryNameDao(String categoryId){  //种类编号
        String categoryName = "";
        Connection conn=DBManager.getConnection();
        PreparedStatement stat=null; // PreparedStatement可以有效防止sql注入，
        ResultSet rs=null;
        try {
            stat=conn.prepareStatement("select * from products where categoryid = ?");
            stat.setString(1, categoryId);
            rs=stat.executeQuery();
            rs.next();
            categoryName =rs.getString(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBManager.closeAll(conn, stat, rs);
        }
        return categoryName;
    }
}
