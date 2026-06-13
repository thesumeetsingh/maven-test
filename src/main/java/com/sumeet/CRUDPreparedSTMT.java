package com.sumeet;
import java.util.Scanner;
import java.sql.*;

public class CRUDPreparedSTMT {
    

    public static void main(String args[]){


        Connection con=null;
        Statement stmt=null;
        PreparedStatement pstmt=null;

        try{
            con=JDBCUtil.getConnection();

            String query="INSERT INTO USER_INFO(ID, SNAME, SAGE, SCITY) VALUES(?,?,?,?);";
            pstmt=con.prepareStatement(query);

            System.out.println("Enter Data: ");
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter id: ");
            int id=sc.nextInt();
            System.out.println("Enter name: ");
            String name=sc.next();
            System.out.println("Enter age: ");
            int age=sc.nextInt();
            System.out.println("Enter city: ");
            String city=sc.next();

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4, city);

            sc.close();

            int row=pstmt.executeUpdate();
            if(row==0){
                System.out.println("unable to insert data");
            }else{
                System.out.println("data inserted successfully");
            }
        }catch(SQLException e){
            System.out.println("SQL ERROR");
        }catch(Exception E){
            System.out.println("UNKNOWN ERROR");
        }finally{
            try{
                JDBCUtil.closeConnection(con, pstmt);
            }catch(SQLException e){
                System.out.println("sql error while closing");
            }catch(NullPointerException e){
                System.out.println("NPE ERROR");
            }catch(Exception e){
               System.out.println("UNLNOWN ERROR WHILE CLSOING");
            }
            
        }

    }
}
      