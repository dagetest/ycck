package com.sele.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 2017/4/13.
 */
public class GuanWangZhuCeDengLu {
    private static Log logger = LogFactory.getLog(GuanWangZhuCeDengLu.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver1 = new ChromeDriver();
        // 打开连接
        driver1.get("http://v2-test.zm1v1.com/");
        driver1.manage().window().maximize();
        //注册
        String mobile = "15121212135";
        String password = "12345678";
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            register(driver1,mobile,password);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("官网注册register 出异常了");
        }
//        login(driver1,mobile,password);  //登录驱动，调用下边的登录函数
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        driver1.quit();
        //Thread.sleep(2000); // 2秒钟之后被唤起，开始参与cup的竞争
        //driver.quit();  //关闭驱动，关闭页面。driver。close（）；每运行一次就会产生一个系统临时文件（temp文件名）
    }

    private static void register(WebDriver driver,String mobile,String password) throws InterruptedException {   //register注册页面函数

        //点击首页的注册按钮
        driver.findElement(By.xpath("//*[@id=\"n-top-bar\"]/div/div[2]/a[2]/b")).click();
        //手机号
        driver.findElement(By.xpath("//*[@id=\"mobile-01\"]")).sendKeys(mobile);
        //验证码
        driver.findElement(By.xpath("//*[@id=\"code\"]")).sendKeys("999999");
        driver.findElement(By.xpath("//*[@id=\"verifycode\"]")).sendKeys("999999");
        //学生姓名
        driver.findElement(By.xpath("//*[@id=\"name-01\"]")).sendKeys("自动化测试账号");
        //密码
        driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[5]/input")).sendKeys(password);
        //确认密码
        driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[6]/input")).sendKeys(password);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[9]/button")));
        //其他项
        driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[8]/input")).sendKeys("18739975143");
        //点击注册页面的注册按钮
        driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[9]/button")).click();
        logger.debug("注册成功");
        Thread.sleep(2000);
        //输入手机号
        driver.findElement(By.id("username")).sendKeys(mobile);
        //输入密码
        driver.findElement(By.id("password")).sendKeys(password);
        //点击登录界面的登录按钮
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/button")).click();
        logger.debug("登录成功");
        Thread.sleep(2000);
    }
}