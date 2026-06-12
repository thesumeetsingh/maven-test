package com.sumeet;
import java.sql.*;


public class SQLUpdate {
    public static void main(String args[])throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        String user="root";
        String password="root";
        Connection connect= DriverManager.getConnection(url, user, password);

        
        Statement statement= connect.createStatement();
        String query="UPDATE user_info set sname='SHWETA SINGH' where id=2";

        int rowAffected=statement.executeUpdate(query);


        if(rowAffected==0){
            System.out.println("cannot update row");

        }else{
            System.out.println("row updated successfully");


        }


        statement.close();
        connect.close();
    }
}
