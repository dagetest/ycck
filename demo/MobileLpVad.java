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
public class MobileLpVad {
    private static Log logger = LogFactory.getLog(MobileLpVad.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver = new ChromeDriver();
        // 打开连接
        driver.get("http://v2-test.zm1v1.com/mobile/lp/vad");
        driver.manage().window().maximize();
        //vad报名，免费试听
        String mobile = "15121212141";
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            driver.get("http://v2-test.zm1v1.com/mobile/lp/vad");
            logger.error("MobileLpVad页面getFreeLesson 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        driver.quit();
    }
    private static void getFreeLesson(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //点击第一个预约试听
        //*[@id="book-form-special"]/div[5]/button
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[5]/button"))); //先定位到父级的div
        Thread.sleep(2000);
//        By by = By.xpath("//*[@id=\"wrapper\"]/a[1]/div");  //然后才能点击
//        WebElement element = driver.findElement(by);
//        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("小三");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("数学");
        //定位元素
        JavascriptExecutor js1 = ((JavascriptExecutor) driver);
        js1.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[5]/button")));
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[5]/button")).click();
        Thread.sleep(2000);
        logger.debug("预约成功1");
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
}
