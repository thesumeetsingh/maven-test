package com.sumeet;
import java.sql.*;



public class SQLSelect {
    public static void main(String args[]) throws ClassNotFoundException, SQLException{


        Class.forName("com.mysql.cj.jdbc.Driver");


        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        String user="root";
        String password="root";
        Connection connect= DriverManager.getConnection(url, user, password);

        Statement statement= connect.createStatement();

        String query="SELECT * FROM USER_INFO;";

        ResultSet rs= statement.executeQuery(query);
        // System.out.println(rs);
        while(rs.next()){
            Integer id= rs.getInt("id");
            String name= rs.getString("sname");
            Integer age= rs.getInt("sage");
            String city= rs.getString("scity");

            System.out.println("Student:"+name+" with roll numbner:"+id+" is of age "+age+" and in city "+city);
        }

        rs.close();
        statement.close();
        connect.close();
    }    
}
