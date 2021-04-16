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
 * Created by Administrator on 2017/4/14.
 */
public class GuanWangGongKaiKe {
    private static Log logger = LogFactory.getLog(GuanWangGongKaiKe.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver = new ChromeDriver();
        // 打开连接
        driver.get("https://v2-test.zm1v1.com/");
        driver.manage().window().maximize();
        //免费试听
        String mobile = "15121212100";
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("公开课getFreeLesson出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson1(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("公开课getFreeLesson1出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson2(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("公开课getFreeLesson2出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        driver.quit();
    }
    private static void getFreeLesson(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        // driver是驱动程序，findElement 查找页面元素  使用By.Xpath快速定位页面元素
        //点击公开课
        driver.findElement(By.xpath("//*[@id=\"n-nav-area\"]/a[5]")).click();
        Thread.sleep(3000);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div/div[2]/div/div/ul/li[1]/img"))); //先定位到父级的div
        //点击热门文章
        //*[@id="wrapper"]/div[3]/div/div[2]/div/div/ul/li[2]/img
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div/div[2]/div/div/ul/li[2]/img")).click();
        Thread.sleep(1000);
        //点击0元试听图片
        driver.findElement(By.xpath("//*[@id=\"banner\"]/div/div/a/img")).click();
        // \"reservation"\  \\是转义字符
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/select[1]")));
        sel.selectByValue("小三");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/select[2]")));
        sel2.selectByValue("数学");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[3]/div[1]/input")).sendKeys(mobile);
        //点击0元试听按钮
        driver.findElement(By.id("getFreeLesson")).click();
        Thread.sleep(2000);
        String strUrl2 = "https://v2-test.zm1v1.com/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("公开课页面，第1个0元试听失败！");
        }else{
            logger.debug("公开课页面，第1个0元试听成功！");
        }
//        // 点击预约成功的蒙版
//        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/h2")).click();
//        Thread.sleep(2000);
//        //退出操作
//        driver.findElement(By.xpath("//*[@id=\"n-top-bar\"]/div/div[2]/a[3]/b")).click();
//        Thread.sleep(3000);
    }
    private static void getFreeLesson1(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("https://v2-test.zm1v1.com/");
        // driver是驱动程序，findElement 查找页面元素  使用By.Xpath快速定位页面元素

        //点击公开课
        driver.findElement(By.xpath("//*[@id=\"n-nav-area\"]/a[5]")).click();
        Thread.sleep(3000);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div/div[2]/div/div/ul/li[1]/img"))); //先定位到父级的div
        //点击热门文章
        //*[@id="wrapper"]/div[3]/div/div[2]/div/div/ul/li[2]/img
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div/div[2]/div/div/ul/li[2]/img")).click();
        Thread.sleep(1000);
        //定位到第二个免费试听处
        JavascriptExecutor js1 = ((JavascriptExecutor) driver);
        js1.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"appoint-box\"]/a")));
        //点击0元试听图片
        //*[@id="appoint-box"]/a
        driver.findElement(By.xpath("//*[@id=\"appoint-box\"]/a")).click();
        // \"reservation"\  \\是转义字符
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/select[1]")));
        sel.selectByValue("高一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/select[2]")));
        sel2.selectByValue("历史");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[3]/div[1]/input")).sendKeys(mobile);
        //点击0元试听按钮
        driver.findElement(By.id("getFreeLesson")).click();
        Thread.sleep(2000);
        String strUrl2 = "https://v2-test.zm1v1.com/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("公开课页面，第2个0元试听失败！");
        }else{
            logger.debug("公开课页面，第2个0元试听成功！");
        }
//        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/h2")).click();
//        Thread.sleep(2000);
//        //退出操作
//        driver.findElement(By.xpath("//*[@id=\"n-top-bar\"]/div/div[2]/a[3]/b")).click();
//        Thread.sleep(3000);
    }
    private static void getFreeLesson2(WebDriver driver,String mobile) throws InterruptedException {
        driver.get("https://v2-test.zm1v1.com/");
        // 点击预约成功的蒙版

        //点击公开课
        driver.findElement(By.xpath("//*[@id=\"n-nav-area\"]/a[5]")).click();
        Thread.sleep(2000);
        //点击第二个免费试听按钮
        driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[3]/select")));
        sel.selectByValue("高三");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[4]/select")));
        sel2.selectByValue("语文");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[2]/div[1]/input")).sendKeys(mobile);
        //点击0元试听按钮
        driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[5]/button")).click();
        Thread.sleep(2000);
        String strUrl2 = "https://v2-test.zm1v1.com/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("公开课页面，第3个0元试听失败！");
        }else{
            logger.debug("公开课页面，第3个0元试听成功！");
        }
        // 点击预约成功的蒙版
//        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/h2")).click();
//        Thread.sleep(2000);
//        //退出操作
//        driver.findElement(By.xpath("//*[@id=\"n-top-bar\"]/div/div[2]/a[3]/b")).click();
//        Thread.sleep(2000);
    }
}
