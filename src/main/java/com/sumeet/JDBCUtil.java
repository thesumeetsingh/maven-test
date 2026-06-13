package com.sumeet;
import java.sql.*;
public class JDBCUtil {
    

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{

        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        String user="root";
        String password="root";
        return DriverManager.getConnection(url, user, password);
        
    }

    public static void closeConnection(Connection con, Statement stmt) throws SQLException{
        con.close();
        stmt.close();
    }
}
