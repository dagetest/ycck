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
 * Created by Administrator on 2017/5/12.
 */
public class MobileLpFeed {
    private static Log logger = LogFactory.getLog(MobileLpDsp.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver = new ChromeDriver();
        // 打开连接
        driver.get("http://v2-test.zm1v1.com/mobile/lp/feed");
        driver.manage().window().maximize();
        //青少年在线教育，免费试听
        String mobile = "10000000051";
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("MobileLpFeed页面getFreeLesson 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson1(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("MobileLpFeed页面getFreeLesson1 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson2(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("MobileLpFeed页面getFreeLesson2 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson3(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("MobileLpFeed页面getFreeLesson3 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson4(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("MobileLpFeed页面getFreeLesson4 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        driver.quit();
    }

    private static void getFreeLesson(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //点击第一个预约试听
        //*[@id="mheaderbtn2"]
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"book-form-feed\"]/div[5]/button"))); //先定位到父级的div
        Thread.sleep(1000);
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
        Thread.sleep(1000);
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"book-form-feed\"]/div[5]/button")).click();
        Thread.sleep(1000);
        String strUrl2 = "http://v2-test.zm1v1.com/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("MobileLpFeed页面getFreeLesson 报名成功");
        }else{
            logger.debug("MobileLpFeed页面getFreeLesson 报名失败");
        }
    }
    private static void getFreeLesson1(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/mobile/lp/feed");
        //点击第二个报名按钮
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"student-list\"]/div/a"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"student-list\"]/div/a");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //*[@id="book-form-feed"]/div[5]/button
        String s1 = new String("//*[@id=\"book-form-feed\"]/div[5]/button");
        if(s1.equals(driver.findElement(By.xpath("//*[@id=\"book-form-feed\"]/div[5]/button")))){
            logger.debug("MobileLpFeed页面getFreeLesson1 跳转成功");
        } else {
            logger.debug("MobileLpFeed页面getFreeLesson1 跳转失败");
        }
    }

    private static void getFreeLesson2(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/mobile/lp/feed");
        //点击第三个预约试听
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"what\"]/div/div/a"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"what\"]/div/div/a");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        String s1 = new String("//*[@id=\"book-form-feed\"]/div[5]/button");
        if(s1.equals(driver.findElement(By.xpath("//*[@id=\"book-form-feed\"]/div[5]/button")))){
            logger.debug("MobileLpFeed页面getFreeLesson2 跳转成功");
        } else {
            logger.debug("MobileLpFeed页面getFreeLesson2 跳转失败");
        }
    }
    private static void getFreeLesson3(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/mobile/lp/feed");
        //点击第四个预约试听
        //*[@id="wrapper"]/div[5]/div/a/div
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"lesson-types\"]/div[2]/a"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"lesson-types\"]/div[2]/a");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        String s1 = new String("//*[@id=\"book-form-feed\"]/div[5]/button");
        if(s1.equals(driver.findElement(By.xpath("//*[@id=\"book-form-feed\"]/div[5]/button")))){
            logger.debug("MobileLpFeed页面getFreeLesson3 跳转成功");
        } else {
            logger.debug("MobileLpFeed页面getFreeLesson3 跳转失败");
        }
    }
    private static void getFreeLesson4(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/mobile/lp/feed");
        //点击第五个预约试听
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"book-form-feed2\"]/div[5]/button"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"book-form-feed2\"]/div[5]/button");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("小六");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("语文");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        Thread.sleep(1000);
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"book-form-feed2\"]/div[5]/button")).click();
        String strUrl2 = "http://v2-test.zm1v1.com/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("MobileLpFeed页面getFreeLesson4 报名成功");
        }else{
            logger.debug("MobileLpFeed页面getFreeLesson4 报名失败");
        }
    }
}
