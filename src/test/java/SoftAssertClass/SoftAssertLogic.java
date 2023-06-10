package SoftAssertClass;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertLogic {
  public int getSum(int number1, int number2){
      return number1+number2;
  }
  @Test
    public void HardAssert(){
      Assert.assertEquals(getSum(1,5),6);
      System.out.println("test1");

      Assert.assertEquals(getSum(3,7),10);
      System.out.println("test2");

      Assert.assertEquals(getSum(5,9),14);
      System.out.println("test3");
  }

  @Test
  public void SoftAssert(){
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(getSum(1,5),6);
    System.out.println("test1");

    softAssert.assertEquals(getSum(3,7),1111);
    System.out.println("test2");

    softAssert.assertEquals(getSum(5,9),14);
    System.out.println("test3");

    softAssert.assertAll();


  }
    }

