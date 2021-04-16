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
 * Created by Administrator on 2017/4/17.
 */
public class Mobile {
    private static Log logger = LogFactory.getLog(Mobile.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver = new ChromeDriver();
        // 打开连接
        driver.get("http://v2-test.zm1v1.com/mobile/");
        driver.manage().window().maximize();
        //青少年在线教育，免费试听
        String mobile = "15121212137";
//        for(int i = 0; i<10; i++) {
            DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
            try {
                getFreeLesson(driver, mobile);
            } catch (Exception e) {
                System.out.println("出异常了 = [" + args + "]");
                logger.error("Mobile页面getFreeLesson 出异常了");
            }
            DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
            try {
                getFreeLesson1(driver, mobile);
            } catch (Exception e) {
                System.out.println("出异常了 = [" + args + "]");
                logger.error("Mobile页面getFreeLesson1 出异常了");
            }
            DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
            try {
                getFreeLesson2(driver, mobile);
            } catch (Exception e) {
                System.out.println("出异常了 = [" + args + "]");
                logger.error("Mobile页面getFreeLesson2 出异常了");
            }
            DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
            try {
                getFreeLesson3(driver, mobile);
            } catch (Exception e) {
                System.out.println("出异常了 = [" + args + "]");
                logger.error("Mobile页面getFreeLesson3 出异常了");
            }
            DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
            driver.quit();
//        }
    }

    private static void getFreeLesson(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //点击第一个预约试听
        //*[@id="book-form-special"]/div[6]/button
//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[6]"))); //先定位到父级的div
//        Thread.sleep(2000);
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("小三");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("数学");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        //推荐人手机号
//        driver.findElement(By.xpath("//*[@id=\"referrer_Mobile\"]")).sendKeys("10000002014");
//        JavascriptExecutor js1 = ((JavascriptExecutor) driver);
//        js1.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[6]")));
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[6]/button")).click();
        Thread.sleep(1000);
        logger.debug("预约成功1");
    }
    private static void getFreeLesson1(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/mobile/");
        //点击第二个报名按钮
        //*[@id="what"]/div/a/div
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"what\"]/div"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"what\"]/div/a/div");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("化学");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[6]/button")).click();
        Thread.sleep(1000);
        logger.debug("预约成功2");
    }

    private static void getFreeLesson2(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/mobile/");
        //点击第三个预约试听
        //*[@id="video"]/div/ul/li[4]/a/span
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"video\"]/div"))); //先定位到父级的div
        Thread.sleep(2000);
        By by = By.xpath("//*[@id=\"video\"]/div/ul/li[4]/a/span");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("小五");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("奥数");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        //推荐人手机号
//        driver.findElement(By.xpath("//*[@id=\"referrer_Mobile\"]")).sendKeys("10000002014");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[6]/button")).click();
        Thread.sleep(1000);
        logger.debug("预约成功3");
    }
    private static void getFreeLesson3(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/mobile/");
        //点击第四个预约试听
        //*[@id="companyMedia"]/div/a/img
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"companyMedia\"]/div"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"companyMedia\"]/div/a/img");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("小五");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("奥数");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        //推荐人手机号
//        driver.findElement(By.xpath("//*[@id=\"referrer_Mobile\"]")).sendKeys("10000002014");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[6]/button")).click();
        Thread.sleep(1000);
        logger.debug("预约成功4");
    }
}
