package com.sele.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Administrator on 2017/4/15.
 */
public class MobileWechatWechatBinding {
    private static Log logger = LogFactory.getLog(MobileWechatWechatBinding.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver = new ChromeDriver();
        // 打开连接
        driver.get("http://v2-test.zm1v1.com/mobile/wechat/wechat-binding");
        driver.manage().window().maximize();
        //京东白条报名，免费试听
        getFreeLesson(driver); //调用下边的弹窗函数
    }
    private static void getFreeLesson(WebDriver driver) throws InterruptedException {      // private 私有类
        //随时随地修改空闲时间
        Thread.sleep(2000);
        //手机号
        driver.findElement(By.xpath("//*[@id=\"book-form\"]/div[1]/input")).sendKeys("10000002015");
        //密码
        driver.findElement(By.xpath("//*[@id=\"book-form\"]/div[2]/input")).sendKeys("hello2015");
        //点击确认绑定按钮
        driver.findElement(By.xpath("//*[@id=\"book-form\"]/div[3]/button")).click();
        Thread.sleep(2000);
        logger.debug("绑定成功");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.quit();
    }
}
