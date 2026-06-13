package com.sumeet;
import java.sql.*;
import java.util.Scanner;

public class CRUDOperation {

    public static void main(String args[]) throws ClassNotFoundException, SQLException  {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        String user="root";
        String password= "root";

        Connection connect= DriverManager.getConnection(url, user, password);

        Statement statement= connect.createStatement();

        boolean flag=true;
        while(flag){
            System.out.println("Enter your chocie: ");
            System.out.println("1. Insert in Database");
            System.out.println("2. Update in Database");
            System.out.println("3. Delete in Database");
            System.out.println("4. Retrieve All from Database");
            System.out.println("5. Search from Database");
            System.out.println("6. Search from Database");


            Scanner sc= new Scanner(System.in);
            int ch= sc.nextInt();
            if(ch==6){
                
                break;
            }
            switch(ch){
                case 1:
                    System.out.println("enter name: ");
                    String name=sc.next();
                    System.out.println("Enter age: ");
                    int age=sc.nextInt();
                    System.out.println("Enter city: ");
                    String city=sc.next();
                    System.out.println("Enter id: ");
                    int id=sc.nextInt();

                    String query="INSERT INTO USER_INFO(ID, SNAME, SAGE, SCITY) VALUES("+id+",'"+name+"',"+age+",'"+city+"');";
                    int rowAffected= statement.executeUpdate(query);
                    if(rowAffected==0){
                        System.out.println("unable to insert data");
                    }else{
                        System.out.println("data inserted successfully");
                    }
                    break;
                case 2:
                    String updateQuery="";
                    System.out.println("Enter what to update:");
                    System.out.println("1. id 2.name 3.age 4.city");
                    int c= sc.nextInt();
                    System.out.println("Enter new Data: ");
                    if(c==1){
                        int updateId= sc.nextInt();
                        updateQuery="UPDATE USER_INFO SET ID="+updateId;
                    }else if(c==2){
                        String updateName= sc.next();
                        updateQuery="UPDATE USER_INFO SET sname='"+updateName+"' ";
                    }else if(c==3){
                        int updatedAge= sc.nextInt();
                        updateQuery="UPDATE USER_INFO SET sage="+updatedAge;
                    }else if(c==4){
                        String updateCity= sc.next();
                        updateQuery="UPDATE USER_INFO SET scity='"+updateCity+"'";
                    }
                    
                    System.out.println("Enter where to update");
                    System.out.println("1. id 2.name 3.age 4.city");
                    int w=sc.nextInt();
                    if(w==1){
                        System.out.println("Enter id:");
                        int uID=sc.nextInt();
                        updateQuery=updateQuery+"WHERE ID="+uID+";";
                    }else if(w==2){
                        System.out.println("Enter name:");
                        String uName=sc.next();
                        updateQuery=updateQuery+"WHERE sname='"+uName+"';";
                    }else if(w==3){
                        System.out.println("Enter age:");
                        int uAge=sc.nextInt();
                        updateQuery=updateQuery+"WHERE sage="+uAge+";";
                    }else if(w==4){
                        System.out.println("Enter city:");
                        String uCity=sc.next();
                        updateQuery=updateQuery+"WHERE scity='"+uCity+"';";
                    }
                    int rowAffectedUpdate= statement.executeUpdate(updateQuery);
                    if(rowAffectedUpdate==0){
                        System.out.println("error updating data");
                    }else{
                        System.out.println("Data updated successfully");
                    }
                    break;
                case 3:
                    System.out.println("Enter ID to delete data:");
                    int delId= sc.nextInt();
                    String delQuery="DELETE FROM USER_INFO WHERE ID="+delId+";";
                    int delRow=statement.executeUpdate(delQuery);
                    if(delRow==0){
                        System.out.println("error deleting data");
                    }else{
                        System.out.println("Data deleted successfully");
                    }
                    break;
                case 4:
                        String selectQuery="SELECT * FROM USER_INFO;";

                        ResultSet rs= statement.executeQuery(selectQuery);
                        // System.out.println(rs);
                        while(rs.next()){
                            Integer SELid= rs.getInt("id");
                            String selname= rs.getString("sname");
                            Integer Selage= rs.getInt("sage");
                            String selcity= rs.getString("scity");

                            System.out.println("Student:"+selname+" with roll numbner:"+SELid+" is of age "+Selage+" and in city "+selcity);
                        }
                    break;
                case 5:
                    System.out.println("where to search : \n 1.ID  2.NAME 3.AGE 4.CITY");
                    int s= sc.nextInt();
                    System.out.println("Enter what to search : ");
                    String searchQuery="";
                    if(s==1){
                        int sID= sc.nextInt();
                        searchQuery="SELECT * FROM USER_INFO WHERE ID="+sID+";";
                    }else if(s==2){
                        String sName=sc.next();
                        searchQuery="SELECT * FROM USER_INFO WHERE SNAME='"+sName+"';";
                    }else if(s==3){
                        int sAge= sc.nextInt();
                        searchQuery="SELECT * FROM USER_INFO WHERE SAGE="+sAge+";";
                    }else if(s==4){
                        String sCity=sc.next();
                        searchQuery="SELECT * FROM USER_INFO WHERE SCITY='"+sCity+"';";                        
                    }

                    ResultSet searchSet= statement.executeQuery(searchQuery);
                    while(searchSet.next()){
                        Integer getID= searchSet.getInt("id");
                        String getName=  searchSet.getString("sname");
                        Integer getAge=  searchSet.getInt("sage");
                        String getCity=  searchSet.getString("scity");

                        System.out.println("Student:"+getName+" with roll numbner:"+getID+" is of age "+getAge+" and in city "+getCity);                       
                    }
                    
                    break;
                default:
                    System.out.println("Enter valid input");

            }
            sc.close();

            
        }

        statement.close();
        connect.close();
        


        
    }    
}
