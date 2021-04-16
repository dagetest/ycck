package com.sele.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Administrator on 2017/4/14.
 */
public class GuanWangXueYuanKouBei {
    private static Log logger = LogFactory.getLog(GuanWangXueYuanKouBei.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver = new ChromeDriver();
        // 打开连接
        driver.get("https://v2-test.zm1v1.com/");
        driver.manage().window().maximize();
        //免费试听
        String mobile = "15121212132";
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("官网学员口碑getFreeLesson 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson1(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("官网学员口碑getFreeLesson1 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        driver.quit();
    }
    private static void getFreeLesson(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        // driver是驱动程序，findElement 查找页面元素  使用By.Xpath快速定位页面元素
        //点击学员口碑
        driver.findElement(By.xpath("//*[@id=\"n-nav-area\"]/a[4]")).click();
        Thread.sleep(2000);
        //点击免费试听
        driver.findElement(By.xpath("//*[@id=\"banner\"]/div/div/a")).click();
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
            logger.debug("官网学员口碑，第1个0元试听失败！");
        }else{
            logger.debug("官网学员口碑，第1个0元试听成功！");
        }
    }
    private static void getFreeLesson1(WebDriver driver,String mobile) throws InterruptedException {
        driver.get("https://v2-test.zm1v1.com/");

        //点击学员口碑
        driver.findElement(By.xpath("//*[@id=\"n-nav-area\"]/a[4]")).click();
        Thread.sleep(2000);
        //点击第二个免费试听按钮
        driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[2]/div[1]/input")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[3]/select")));
        sel.selectByValue("小三");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[4]/select")));
        sel2.selectByValue("奥数");
        //点击0元试听按钮
        driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[5]/button")).click();
        Thread.sleep(2000);
        String strUrl2 = "https://v2-test.zm1v1.com/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("官网学员口碑，第2个0元试听失败！");
        }else{
            logger.debug("官网学员口碑，第2个0元试听成功！");
        }
    }
}
