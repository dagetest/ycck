package com.sele.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Administrator on 2017/4/15.
 */
public class MobileTeacherUploadExam {
    private static Log logger = LogFactory.getLog(MobileTeacherUploadExam.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver = new ChromeDriver();
        // 打开连接
        driver.get("http://v2-test.zm1v1.com/mobile/teacher/upload-exam");
        driver.manage().window().maximize();
        //京东白条报名，免费试听
        try {
            getFreeLesson(driver);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            driver.get("http://v2-test.zm1v1.com/mobile/teacher/upload-exam");
            logger.error("MobileTeacherUploadExam 页面 getFreeLesson 出异常了");
        }
        driver.quit();
    }
    private static void getFreeLesson(WebDriver driver) throws InterruptedException {      // private 私有类
        //掌门讲师笔试答题
        Thread.sleep(4000);
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("10000002015");
        //科目
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"subject\"]")));
        sel.selectByValue("政治");
        JavascriptExecutor js1 = ((JavascriptExecutor) driver);
        js1.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"exam-upload-form\"]/div[4]/div[2]/ul")));
        //上传图片
        //*[@id="exam-upload-form"]/div[4]/div[2]/ul


        WebElement file = driver.findElement(By.xpath("//*[@id=\"upload-input\"]"));
        file.sendKeys("C:\\Users\\Administrator\\Desktop\\图片\\204.jpg");
        //定位元素
        Thread.sleep(2000);
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"submit-button\"]")));
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"submit-button\"]")).click();
        Thread.sleep(1000);
        logger.debug("公校兼职老师报名成功1");
    }
}
