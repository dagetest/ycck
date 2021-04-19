package com.sele.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Administrator on 2017/4/18.
 */
public class GuanWangShouYeGaoYiGaoErShengWu {
    private static Log logger = LogFactory.getLog(GuanWangShouYeGaoYiGaoErShengWu.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver = new ChromeDriver();
        // 打开连接
        driver.get("https://v2-test.zm1v1.com/");
        driver.manage().window().maximize();
        //免费试听
        String mobile = "15121212122";
        //调用下边的弹窗函数
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("官网首页高一高二生物getFreeLesson 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson1(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("官网首页高一高二生物getFreeLesson1 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson2(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("官网首页高一高二生物getFreeLesson2 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson3(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("官网首页高一高二生物getFreeLesson3 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        driver.quit();
    }
    private static void getFreeLesson(WebDriver driver,String mobile) throws InterruptedException {
        Thread.sleep(2000);
        //官网首页，高一高二
        //*[@id="lessonSystem"]/div/ul[1]/li[4]/a
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"lessonSystem\"]/div")));
        Thread.sleep(2000);
        By by = By.xpath("//*[@id=\"lessonSystem\"]/div/ul[1]/li[4]/a");  //定位到高一高二
        WebElement element = driver.findElement(by);
        Actions action = new Actions(driver);   //创建一个动作
        action.moveToElement(element).build().perform();  //移动到元素上
        //点击高一高二生物
        //*[@id="lessonSystem"]/div/ul[2]/li[6]/a
        driver.findElement(By.xpath("//*[@id=\"lessonSystem\"]/div/ul[2]/li[6]/a")).click();
        Thread.sleep(2000);
        //*[@id="banner"]/div/div/div/a
        driver.findElement(By.xpath("//*[@id=\"banner\"]/div/div/div/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/select[1]")));
        sel.selectByValue("小三");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/select[2]")));
        sel2.selectByValue("数学");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[3]/div[1]/input")).sendKeys(mobile);
        Thread.sleep(1000);
        //点击0元试听按钮
        driver.findElement(By.xpath("//*[@id=\"getFreeLesson\"]")).click();
        Thread.sleep(2000);
        String strUrl2 = "https://v2-test.zm1v1.com/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("官网首页高一高二生物课程，第1个0元试听失败！");
        }else{
            logger.debug("官网首页高一高二生物课程，第1个0元试听成功！");
        }
    }
    private static void getFreeLesson1(WebDriver driver,String mobile) throws InterruptedException {
        driver.get("https://v2-test.zm1v1.com/");

        //官网首页，高一高二
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"lessonSystem\"]/div")));
        Thread.sleep(2000);
        By by = By.xpath("//*[@id=\"lessonSystem\"]/div/ul[1]/li[4]/a");  //定位到高一高二
        WebElement element = driver.findElement(by);
        Actions action = new Actions(driver);   //创建一个动作
        action.moveToElement(element).build().perform();  //移动到元素上
        //点击高一高二生物
        //*[@id="lessonSystem"]/div/ul[2]/li[6]/a
        driver.findElement(By.xpath("//*[@id=\"lessonSystem\"]/div/ul[2]/li[6]/a")).click();
        Thread.sleep(2000);
        //高一高二生物页面，定位第二个报名按钮
        //*[@id="three"]/div/div[3]/a
        JavascriptExecutor js1 = ((JavascriptExecutor) driver);
        js1.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"three\"]/div"))); //先定位到父级的div
        driver.findElement(By.xpath("//*[@id=\"three\"]/div/div[3]/a")).click();
        //点击第二个免费试听按钮
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/select[1]")));
        sel.selectByValue("高二");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/select[2]")));
        sel2.selectByValue("历史");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[3]/div[1]/input")).sendKeys(mobile);
        Thread.sleep(1000);
        //点击0元试听按钮
        driver.findElement(By.xpath("//*[@id=\"getFreeLesson\"]")).click();
        Thread.sleep(2000);
        String strUrl2 = "https://v2-test.zm1v1.com/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("官网首页高一高二生物课程，第2个0元试听失败！");
        }else{
            logger.debug("官网首页高一高二生物课程，第2个0元试听成功！");
        }
    }
    private static void getFreeLesson2(WebDriver driver,String mobile) throws InterruptedException {
        driver.get("https://v2-test.zm1v1.com/");

        //官网首页，高一高二
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"lessonSystem\"]/div")));
        Thread.sleep(2000);
        By by = By.xpath("//*[@id=\"lessonSystem\"]/div/ul[1]/li[4]/a");  //定位到高一高二
        WebElement element = driver.findElement(by);
        Actions action = new Actions(driver);   //创建一个动作
        action.moveToElement(element).build().perform();  //移动到元素上
        //点击高一高二生物
        //*[@id="lessonSystem"]/div/ul[2]/li[6]/a
        driver.findElement(By.xpath("//*[@id=\"lessonSystem\"]/div/ul[2]/li[6]/a")).click();
        Thread.sleep(2000);
        //高一高二生物页面，定位第三个报名按钮
        //*[@id="checkMissingTrap"]/div/div[2]/a
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"checkMissingTrap\"]/div"))); //先定位到父级的div
        driver.findElement(By.xpath("//*[@id=\"checkMissingTrap\"]/div/div[2]/a")).click();
        //点击第三个免费试听按钮
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/select[1]")));
        sel.selectByValue("高二");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/select[2]")));
        sel2.selectByValue("历史");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[3]/div[1]/input")).sendKeys(mobile);
        Thread.sleep(1000);
        //点击0元试听按钮
        driver.findElement(By.xpath("//*[@id=\"getFreeLesson\"]")).click();
        Thread.sleep(2000);
        String strUrl2 = "https://v2-test.zm1v1.com/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("官网首页高一高二生物课程，第3个0元试听失败！");
        }else{
            logger.debug("官网首页高一高二生物课程，第3个0元试听成功！");
        }
    }
    private static void getFreeLesson3(WebDriver driver,String mobile) throws InterruptedException {
        driver.get("https://v2-test.zm1v1.com/");

        //官网首页，高一高二
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"lessonSystem\"]/div")));
        Thread.sleep(2000);
        By by = By.xpath("//*[@id=\"lessonSystem\"]/div/ul[1]/li[4]/a");  //定位到高一高二
        WebElement element = driver.findElement(by);
        Actions action = new Actions(driver);   //创建一个动作
        action.moveToElement(element).build().perform();  //移动到元素上
        //点击高一高二生物
        //*[@id="lessonSystem"]/div/ul[2]/li[6]/a
        driver.findElement(By.xpath("//*[@id=\"lessonSystem\"]/div/ul[2]/li[6]/a")).click();
        Thread.sleep(2000);
        //点击第四个免费试听按钮
        driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[2]/div[1]/input")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[3]/select")));
        sel.selectByValue("高三");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[4]/select")));
        sel2.selectByValue("语文");
        Thread.sleep(1000);
        //点击0元试听按钮
        //*[@id="reservation-bar"]/form/div[5]/button
        driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[5]/button")).click();
        Thread.sleep(2000);
        String strUrl2 = "https://v2-test.zm1v1.com/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("官网首页高一高二生物课程，第4个0元试听失败！");
        }else{
            logger.debug("官网首页高一高二生物课程，第4个0元试听成功！");
        }
    }
}
