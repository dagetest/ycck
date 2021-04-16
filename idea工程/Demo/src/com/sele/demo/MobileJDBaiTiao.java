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
public class MobileJDBaiTiao {
    private static Log logger = LogFactory.getLog(MobileJDBaiTiao.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver = new ChromeDriver();
        // 打开连接
        driver.get("http://v2-test.zm1v1.com/mobile/jdbaitiao");
        driver.manage().window().maximize();
        //京东白条报名，免费试听
        String mobile = "15121212138";
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            Vorlage(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            driver.get("http://v2-test.zm1v1.com/mobile/jdbaitiao");
            logger.error("MobileJDBaiTiao页面Vorlage 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            Vorlage1(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            driver.get("http://v2-test.zm1v1.com/mobile/jdbaitiao");
            logger.error("MobileJDBaiTiao页面Vorlage1 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            Vorlage2(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            driver.get("http://v2-test.zm1v1.com/mobile/jdbaitiao");
            logger.error("MobileJDBaiTiao页面Vorlage2 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            Vorlage3(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            driver.get("http://v2-test.zm1v1.com/mobile/jdbaitiao");
            logger.error("MobileJDBaiTiao页面Vorlage3 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            Vorlage4(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            driver.get("http://v2-test.zm1v1.com/mobile/jdbaitiao");
            logger.error("MobileJDBaiTiao页面Vorlage4 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            Vorlage5(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            driver.get("http://v2-test.zm1v1.com/mobile/jdbaitiao");
            logger.error("MobileJDBaiTiao页面Vorlage5 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            Vorlage6(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            driver.get("http://v2-test.zm1v1.com/mobile/jdbaitiao");
            logger.error("MobileJDBaiTiao页面Vorlage6 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        driver.quit();
    }
    private static void Vorlage(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //点击第一个预约试听
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"wrapper\"]/a[1]"))); //先定位到父级的div
        Thread.sleep(2000);
        By by = By.xpath("//*[@id=\"wrapper\"]/a[1]/div");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("小三");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("数学");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[5]/button")).click();
        logger.debug("预约成功1");
        Thread.sleep(3000);
        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
    private static void Vorlage1(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //点击提交按钮
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"name\"]"))); //先定位到父级的div
        Thread.sleep(1000);
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("高三");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("化学");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[5]/button")).click();
        logger.debug("预约成功2");
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
    private static void Vorlage2(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //点击第三个预约试听
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"wrapper\"]/a[2]"))); //先定位到父级的div
        Thread.sleep(2000);
        By by = By.xpath("//*[@id=\"wrapper\"]/a[2]/div");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("小六");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("英语");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[5]/button")).click();
        logger.debug("预约成功3");
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
    private static void Vorlage3(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //点击第四个预约试听
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"wrapper\"]/div[5]/a/div");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("高一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("政治");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[5]/button")).click();
        logger.debug("预约成功4");
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
    private static void Vorlage4(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //点击第五个预约试听
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[6]/a/div"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"wrapper\"]/div[6]/a/div");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("初三");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("语文");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[5]/button")).click();
        logger.debug("预约成功5");
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
    private static void Vorlage5(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //点击第六个预约试听
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"wrapper\"]/a[3]/div"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"wrapper\"]/a[3]/div");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("初二");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("历史");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[5]/button")).click();
        logger.debug("预约成功6");
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
    private static void Vorlage6(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //点击第六个预约试听
        driver.findElement(By.xpath("//*[@id=\"mfooterbtn\"]/div/span")).click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("物理");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"book-form-special\"]/div[5]/button")).click();
        logger.debug("预约成功7");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
    }
}
