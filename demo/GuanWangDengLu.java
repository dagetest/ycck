package com.sele.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Created by Administrator on 2017/4/13.
 */
public class GuanWangDengLu {
    private static Log logger = LogFactory.getLog(GuanWangDengLu.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver = new ChromeDriver();
        // 打开连接
        driver.get("http://v2-test.zm1v1.com/");
        driver.manage().window().maximize();

        login(driver);  //登录驱动，调用下边的登录函数
        driver.quit();  //关闭驱动，关闭页面。driver。close（）；每运行一次就会产生一个系统临时文件（temp文件名）
    }
    private static void login(WebDriver driver) throws InterruptedException {  //login登录函数
        //点击首页的登录按钮
        driver.findElement(By.xpath("//*[@id=\"n-top-bar\"]/div/div[2]/a[1]/b")).click();
        //输入手机号
        driver.findElement(By.id("username")).sendKeys("18739975142");
        //输入密码
        driver.findElement(By.id("password")).sendKeys("123456789");
        //点击登录界面的登录按钮
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/button")).click();
        Thread.sleep(1000);
        try{
            WebElement quitle = driver.findElement(By.xpath("//*[@id=\"n-top-bar\"]/div/div[2]/a[3]/b"));
            if(quitle == null){
                logger.debug("官网登录失败");
                //log.error("官网登录失败");
            }else{
                logger.debug("登录成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("登录失败");
        }


        //退出操作
        driver.findElement(By.xpath("//*[@id=\"n-top-bar\"]/div/div[2]/a[3]/b")).click();
        //如果是老用户，且密码修改过则不需要运行以下代码
//        Alert changePwdConfirmDialog = driver.switchTo().alert();
//        System.out.println(changePwdConfirmDialog.getText());
        //取消修改密码
//        changePwdConfirmDialog.dismiss();
        //确认修改密码
//        changePwdConfirmDialog.accept();
        //修改密码操作
//        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345678");
//        driver.findElement(By.xpath("//*[@id=\"new-password\"]")).sendKeys("12345678");
//        driver.findElement(By.xpath("//*[@id=\"new-password-confirmation\"]")).sendKeys("12345678");
//        driver.findElement(By.xpath("//*[@id=\"change-psw-form\"]/div[4]/button")).click();
//        Alert reLoginConfirmDialog = driver.switchTo().alert();
//        reLoginConfirmDialog.accept();
        Thread.sleep(2000);
    }
}
