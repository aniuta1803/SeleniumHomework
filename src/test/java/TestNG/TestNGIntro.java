package TestNG;


import org.testng.annotations.Test;

public class TestNGIntro {
    @Test(priority = 1, invocationCount = 10)

    public void test1(){
        System.out.println("I'm test1");


        }
    @Test(priority = 2)
    public void test2(){
        System.out.println("I'm test2");
    }

    @Test(priority = 3)

    public void test3(){
        System.out.println("I'm test3");

}
}
