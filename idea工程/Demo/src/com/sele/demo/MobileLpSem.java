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
public class MobileLpSem {
    private static Log logger = LogFactory.getLog(MobileLpSem.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver = new ChromeDriver();
        // 打开连接
        driver.get("http://v2-test.zm1v1.com/mobile/lp/sem");
        driver.manage().window().maximize();
        //青少年在线教育，免费试听
        String mobile = "11110000046";
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("MobileLpSem页面getFreeLesson 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson1(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("MobileLpSem页面getFreeLesson1 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson2(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("MobileLpSem页面getFreeLesson2 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson3(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("MobileLpSem页面getFreeLesson3 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson4(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("MobileLpSem页面getFreeLesson4 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson5(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("MobileLpSem页面getFreeLesson5 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        driver.quit();
    }

    private static void getFreeLesson(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //点击第一个预约试听
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]"))); //先定位到父级的div
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
        JavascriptExecutor js1 = ((JavascriptExecutor) driver);
        js1.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"mheaderbtn2\"]"))); //先定位到父级的div
        Thread.sleep(1000);
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"mheaderbtn2\"]")).click();
        String strUrl2 = "http://v2-test.zm1v1.com/mobile/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("MobileLpSem页面getFreeLesson  报名成功");
        }else{
            logger.debug("MobileLpSem页面getFreeLesson  报名失败");
        }
//        driver.navigate().back();
//        Thread.sleep(1000);
//        driver.navigate().refresh();
//        Thread.sleep(1000);
    }
    private static void getFreeLesson1(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/mobile/lp/sem");
        //点击第二个报名按钮
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"lesson-types\"]/a"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"lesson-types\"]/a");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("物理");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        Thread.sleep(1000);
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"mheaderbtn2\"]")).click();
        String strUrl2 = "http://v2-test.zm1v1.com/mobile/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("MobileLpSem页面getFreeLesson1  报名成功");
        }else{
            logger.debug("MobileLpSem页面getFreeLesson1  报名失败");
        }
    }

    private static void getFreeLesson2(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/mobile/lp/sem");
        //点击第三个预约试听
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"show-students\"]/a"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"show-students\"]/a");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("物理");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        Thread.sleep(1000);
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"mheaderbtn2\"]")).click();
        String strUrl2 = "http://v2-test.zm1v1.com/mobile/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("MobileLpSem页面getFreeLesson2  报名成功");
        }else{
            logger.debug("MobileLpSem页面getFreeLesson2  报名失败");
        }
    }
    private static void getFreeLesson3(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/mobile/lp/sem");
        //点击第四个预约试听
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"teacher-list\"]/a"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"teacher-list\"]/a");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("物理");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        Thread.sleep(1000);
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"mheaderbtn2\"]")).click();
        String strUrl2 = "http://v2-test.zm1v1.com/mobile/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("MobileLpSem页面getFreeLesson3  报名成功");
        }else{
            logger.debug("MobileLpSem页面getFreeLesson3  报名失败");
        }
    }
    private static void getFreeLesson4(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/mobile/lp/sem");
        //点击第五个预约试听
        //*[@id="student-map"]/a
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"student-map\"]/a"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"student-map\"]/a");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("物理");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        Thread.sleep(1000);
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"mheaderbtn2\"]")).click();
        String strUrl2 = "http://v2-test.zm1v1.com/mobile/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("MobileLpSem页面getFreeLesson4  报名成功");
        }else{
            logger.debug("MobileLpSem页面getFreeLesson4  报名失败");
        }
    }
    private static void getFreeLesson5(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/mobile/lp/sem");
        //点击第六个预约试听
        //*[@id="mfooterbtn"]/div
        driver.findElement(By.xpath("//*[@id=\"mfooterbtn\"]/div")).click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("物理");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"stu_mobile\"]")).sendKeys(mobile);
        Thread.sleep(1000);
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"mheaderbtn2\"]")).click();
        String strUrl2 = "http://v2-test.zm1v1.com/mobile/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("MobileLpSem页面getFreeLesson5  报名成功");
        }else{
            logger.debug("MobileLpSem页面getFreeLesson5  报名失败");
        }
    }
}
