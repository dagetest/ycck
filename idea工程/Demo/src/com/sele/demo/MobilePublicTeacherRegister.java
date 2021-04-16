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
public class MobilePublicTeacherRegister {
    private static Log logger = LogFactory.getLog(MobilePublicTeacherRegister.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver = new ChromeDriver();
        // 打开连接
        driver.get("http://v2-test.zm1v1.com/mobile/public-teacher-register");
        driver.manage().window().maximize();
        //京东白条报名，免费试听
        String mobile = "15121212142";
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            driver.get("http://v2-test.zm1v1.com/mobile/public-teacher-register");
            logger.error("MobilePublicTeacherRegister页面getFreeLesson 出异常了");
        }
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson1(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            driver.get("http://v2-test.zm1v1.com/mobile/public-teacher-register");
            logger.error("MobilePublicTeacherRegister页面getFreeLesson1 出异常了");
        }
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
    }
    private static void getFreeLesson(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //公校兼职老师报名
        Thread.sleep(4000);
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys(mobile);
        //邮箱
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("987654");
        //邮箱后缀
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"select-email\"]")));
        sel.selectByValue("@hotmail.com");
        //QQ
        driver.findElement(By.xpath("//*[@id=\"qq\"]")).sendKeys("2254478585");
        //定位元素
        JavascriptExecutor js1 = ((JavascriptExecutor) driver);
        js1.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[10]/button")));
        //授课学校
        driver.findElement(By.xpath("//*[@id=\"school\"]")).sendKeys("北京大学");
        //授课学校所在省份
        Select sel1 = new Select(driver.findElement(By.xpath("//*[@id=\"province\"]")));
        sel1.selectByValue("河南省");
        //第一志愿
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"good-first\"]")));
        sel2.selectByValue("地理");
        //年级偏好
        Select sel3 = new Select(driver.findElement(By.xpath("//*[@id=\"grade-first\"]")));
        sel3.selectByValue("初中");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[10]/button")).click();
        Thread.sleep(2000);
        logger.debug("公校兼职老师报名成功1");
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
    private static void getFreeLesson1(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //公校兼职老师报名
        Thread.sleep(2000);
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys(mobile);
        //邮箱
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("987654");
        //邮箱后缀
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"select-email\"]")));
        sel.selectByValue("@hotmail.com");
        //QQ
        driver.findElement(By.xpath("//*[@id=\"qq\"]")).sendKeys("2254478585");
        //定位元素
        JavascriptExecutor js1 = ((JavascriptExecutor) driver);
        js1.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[10]/button")));
        //授课学校
        driver.findElement(By.xpath("//*[@id=\"school\"]")).sendKeys("北京大学");
        //授课学校所在省份
        Select sel1 = new Select(driver.findElement(By.xpath("//*[@id=\"province\"]")));
        sel1.selectByValue("河南省");
        //第一志愿
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"good-first\"]")));
        sel2.selectByValue("地理");
        //年级偏好
        Select sel3 = new Select(driver.findElement(By.xpath("//*[@id=\"grade-first\"]")));
        sel3.selectByValue("初中");
        //推介人
        driver.findElement(By.xpath("//*[@id=\"referrer-mobile\"]")).sendKeys("10000002014");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[10]/button")).click();
        Thread.sleep(2000);
        logger.debug("公校兼职老师报名成功2");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.quit();
    }
}
