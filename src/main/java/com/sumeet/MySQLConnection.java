package com.sumeet;
import java.sql.*;

public class MySQLConnection {


    public static void main(String args[]) throws ClassNotFoundException, SQLException, Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        String user="root";
        String password="root";
        Connection connect= DriverManager.getConnection(url, user, password);

        //create statment
        Statement statement= connect.createStatement();

        //process data

        //close resources
        connect.close();


    }
}
