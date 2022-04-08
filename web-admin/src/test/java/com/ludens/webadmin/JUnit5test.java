package com.ludens.webadmin;

import org.junit.jupiter.api.*;
import org.springframework.util.Assert;

import java.util.concurrent.TimeUnit;

@DisplayName("JUnit5功能测试")
public class JUnit5test {

    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertion(){
        int cal = cal(2,3);
        //断言：前面断言失败，后面的代码则不会执行
        //检查是否相等
        Assertions.assertEquals(6,cal);
    }
    public int cal(int a, int b){
        return a+b;
    }

    @DisplayName("测试数组断言")
    @Test
    void testArraysAssertion(){
        Assertions.assertArrayEquals(new int[]{1,2},new int[]{1,2});
    }


    @DisplayName("测试组合断言")
    @Test
    void all(){
        //必须两个全断言正确，assertAll才正确
        Assertions.assertAll("test",
                ()->Assertions.assertEquals(1,2),
                ()->Assertions.assertTrue(true&&true)
        );
    }

    @DisplayName("异常断言")
    @Test
    void testException(){
        Assertions.assertThrows(ArithmeticException.class,()->{int i = 10/0;}
        );
    }

    @DisplayName("快速失败")
    @Test
    void quickFail(){
        Assertions.fail("快速去世");
    }

    @DisplayName("测试assumption")
    @Test
    void testAssumptions(){
        Assumptions.assumeTrue(false);
        System.out.println("来日方长");
    }
//    @Test
//    @DisplayName("测试Display注解")     //为测试类或测试方法来配置名称
//    void testDisplayName(){
//        System.out.println("1");
//    }
//
//    @BeforeEach                         //在每个单元测试之前执行
//    void testBeforeEach(){
//        System.out.println("测试即将开始");
//    }
//
//    @AfterEach                          //在每个单元测试之后执行
//    void testAfterEach(){
//        System.out.println("测试已经结束");
//    }
//
//    @BeforeAll                          //在所有测试单元前执行
//    static void testBeforeAll(){
//        System.out.println("所有测试开始");
//    }
//
//    @Test
//    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS) //设置超时时间
//    void testTimeout(){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

}
