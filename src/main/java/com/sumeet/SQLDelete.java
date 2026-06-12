package com.sumeet;
import java.sql.*;


public class SQLDelete {
    public static void main(String argsp[]) throws ClassNotFoundException, SQLException{

        Class.forName("com.mysql.cj.jdbc.Driver");


        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        String user="root";
        String password="root";
        Connection connect= DriverManager.getConnection(url, user, password);
        Statement statement=connect.createStatement();

        String query="DELETE FROM USER_INFO WHERE ID=4;";

        int rowAffected= statement.executeUpdate(query);

        if(rowAffected==0){
            System.out.println("failed delete");
        }else{
            System.out.println("data deleted successfully");
        }

        statement.close();
        connect.close();
    }
}
