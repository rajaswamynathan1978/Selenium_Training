package testNG_Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {
   @Test
   @Parameters("myName_1")
   public void parameterTest(String myName) 
   {
      System.out.println("Parameterized value is : " + myName);
   }
}