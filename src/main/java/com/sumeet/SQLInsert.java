package com.sumeet;
import java.sql.*;
// import com.mysql.cj.jdbc.Driver;

public class SQLInsert {


    public static void main(String args[]) throws ClassNotFoundException, SQLException, Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        String user="root";
        String password="root";
        Connection connect= DriverManager.getConnection(url, user, password);

        //create statment
        Statement statement= connect.createStatement();

        //process data
        String query= "INSERT INTO USER_INFO(ID, SNAME, SAGE, SCITY) VALUES(5, ' GITA', 16, 'CHENNAI');";
        int rowAffected=statement.executeUpdate(query);
        if(rowAffected==0){
            System.out.println("cannot inseert data");
        }else{
            System.out.println("Data inserted successfully");
        }
        //close resources
        connect.close();


    }
}
