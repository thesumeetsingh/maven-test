package com.sumeet;

public class ForNameExample {
    public static void main(String args[]){
        // Demo demo= new Demo();
        try{
            Class.forName("com.sumeet.Demo");
        }catch(Exception e){
            System.out.print("cannot initialise");
        }
        

    }
    
}

class Demo{
    static{
        System.out.println("in static block of demo");
    }

    {
        System.out.println("this is an instance");
    }
}
