package com.sumeet;

// import org.junit.Test;
// import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestCalc {

    @Test
    public void testDivide(){
        Calc myCalc= new Calc();
        double result= myCalc.divide(10,5);
        double expected= 2;

        assertEquals(expected, result);
    }

    //added commend to test new branch
    
}
