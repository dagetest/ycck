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
 * Created by Administrator on 2017/5/5.
 */
public class MobileTeacherWechat {
    private static Log logger = LogFactory.getLog(MobileTeacherRegister.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver = new ChromeDriver();
        driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?wechat_account=zmforum");
        driver.manage().window().maximize();
        String mobile = "15121212144";
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?wechat_account=zmforum");
            logger.error("MobileTeacherWechat页面getFreeLesson 出异常了");
        }
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson1(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?wechat_account=zmforum");
            logger.error("MobileTeacherWechat页面getFreeLesson1 出异常了");
        }
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        driver.quit();
    }
    private static void getFreeLesson(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //掌门讲师报名
        Thread.sleep(2000);
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys(mobile);
        //邮箱
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("987654");
        //邮箱后缀
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"select-email\"]")));
        sel.selectByValue("@sohu.com");
        //QQ
        driver.findElement(By.xpath("//*[@id=\"qq\"]")).sendKeys("2254478585");
        //定位元素
        JavascriptExecutor js1 = ((JavascriptExecutor) driver);
        js1.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"register-form1\"]/div[11]/button")));
        //现在居住地址
        //*[@id="location"]
        driver.findElement(By.xpath("//*[@id=\"location\"]")).sendKeys("测试专用地址");
        //报名科目
        //*[@id="apply_grade"]
        Select sel1 = new Select(driver.findElement(By.xpath("//*[@id=\"apply_grade\"]")));
        sel1.selectByValue("初中");
        //科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"applySubject\"]")));
        sel2.selectByValue("语文");
        //是否接受调剂
        //driver.findElement(By.id("accept_adjust")).click();
        Select sel3 = new Select(driver.findElement(By.id("accept_adjust")));
        sel3.selectByValue("0");
        //推介人
        //driver.findElement(By.xpath("//*[@id=\"referrer-mobile\"]")).sendKeys("10000002014");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"register-form1\"]/div[11]/button")).click();
        Thread.sleep(2000);
        //*[@id="time_type"]
        Select sel4 = new Select(driver.findElement(By.xpath("//*[@id=\"time_type\"]")));
        sel4.selectByValue("2");
        Select sel5 = new Select(driver.findElement(By.xpath("//*[@id=\"job_wanted_state\"]")));
        sel5.selectByValue("4");
        //*[@id="fastest_take_office"]
        Select sel6 = new Select(driver.findElement(By.xpath("//*[@id=\"fastest_take_office\"]")));
        sel6.selectByValue("两周内");
        //*[@id="career_planning"]
        Select sel7 = new Select(driver.findElement(By.xpath("//*[@id=\"career_planning\"]")));
        sel7.selectByValue("1");
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"register-form2\"]/div[5]/button")));
        //*[@id="register-form2"]/div[5]/button
        driver.findElement(By.xpath("//*[@id=\"register-form2\"]/div[5]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"register-form4\"]/div[1]/div[2]/input")).sendKeys("自动化测试账号");
        driver.findElement(By.xpath("//*[@id=\"register-form4\"]/div[1]/div[3]/input")).sendKeys("自动化测试账号");
        Select sel8 = new Select(driver.findElement(By.xpath("//*[@id=\"register-form4\"]/div[1]/div[4]/select[1]")));
        sel8.selectByValue("1");
        Select sel9 = new Select(driver.findElement(By.xpath("//*[@id=\"register-form4\"]/div[1]/div[4]/select[2]")));
        sel9.selectByValue("2014");
        driver.findElement(By.xpath("//*[@id=\"register-form4\"]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"register-form4\"]/div[2]/div[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"register-form4\"]/div[2]/button")).click();
        Thread.sleep(1000);
        WebElement quitle = driver.findElement(By.xpath("//*[@id=\"submit-success\"]/div/div[1]/h3"));
        if(quitle == null){
            logger.debug("全职老师报名失败");
        }else{
            logger.debug("全职老师报名成功1");
        }
        driver.navigate().refresh();
    }
    private static void getFreeLesson1(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //掌门讲师报名
        Thread.sleep(2000);
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("自动化测试账号");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys(mobile);
        //邮箱
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("987654");
        //邮箱后缀
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"select-email\"]")));
        sel.selectByValue("@sohu.com");
        //QQ
        driver.findElement(By.xpath("//*[@id=\"qq\"]")).sendKeys("2254478585");
        //定位元素
        JavascriptExecutor js1 = ((JavascriptExecutor) driver);
        js1.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//*[@id=\"register-form1\"]/div[11]/button")));
        //现在居住地址
        //*[@id="location"]
        driver.findElement(By.xpath("//*[@id=\"location\"]")).sendKeys("测试专用地址");
        //报名科目
        //*[@id="apply_grade"]
        Select sel1 = new Select(driver.findElement(By.xpath("//*[@id=\"apply_grade\"]")));
        sel1.selectByValue("初中");
        //科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"applySubject\"]")));
        sel2.selectByValue("数学");
        //是否接受调剂
        //driver.findElement(By.id("accept_adjust")).click();
        Select sel3 = new Select(driver.findElement(By.id("accept_adjust")));
        sel3.selectByValue("0");
        //推介人
        driver.findElement(By.xpath("//*[@id=\"referrer-mobile\"]")).sendKeys("10000002014");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"register-form1\"]/div[11]/button")).click();
        Thread.sleep(2000);
        //*[@id="time_type"]
        Select sel4 = new Select(driver.findElement(By.xpath("//*[@id=\"time_type\"]")));
        sel4.selectByValue("1");
        Select sel5 = new Select(driver.findElement(By.xpath("//*[@id=\"job_wanted_state\"]")));
        sel5.selectByValue("3");
        //*[@id="fastest_take_office"]
        Select sel6 = new Select(driver.findElement(By.xpath("//*[@id=\"fastest_take_office\"]")));
        sel6.selectByValue("两周内");
        //*[@id="career_planning"]
        Select sel7 = new Select(driver.findElement(By.xpath("//*[@id=\"career_planning\"]")));
        sel7.selectByValue("2");
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//*[@id=\"register-form2\"]/div[5]/button")));
        //*[@id="register-form2"]/div[5]/button
        driver.findElement(By.xpath("//*[@id=\"register-form2\"]/div[5]/button")).click();
        Thread.sleep(1000);
        JavascriptExecutor js3 = ((JavascriptExecutor) driver);
        js3.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//*[@id=\"register-form3\"]/div[1]/div[2]/input")));
        //公司名称
        //*[@id="register-form3"]/div[1]/div[2]/input
        driver.findElement(By.xpath("//*[@id=\"register-form3\"]/div[1]/div[2]/input")).sendKeys("自动化测试账号");
        //你的职位
        //*[@id="register-form3"]/div[1]/div[3]/input
        driver.findElement(By.xpath("//*[@id=\"register-form3\"]/div[1]/div[3]/input")).sendKeys("自动化测试账号");
        //起止日期，
//        By by = By.xpath("//*[@id=\"register-form3\"]/div[1]/div[4]/input"); //先停留在输入框上
//        WebElement element = driver.findElement(by);
//        Actions action = new Actions(driver);   //创建一个动作
//        action.moveToElement(element).build().perform();  //移动到元素上
        driver.findElement(By.xpath("//*[@id=\"register-form3\"]/div[1]/div[4]/input")).sendKeys("002017/05/15");
        driver.findElement(By.xpath("//*[@id=\"register-form3\"]/div[1]/div[4]/input")).sendKeys("002017/07/15");

        //离职原因
        //*[@id="register-form3"]/div[1]/div[6]/input
        driver.findElement(By.xpath("//*[@id=\"register-form3\"]/div[1]/div[6]/input")).sendKeys("自动化测试账号");
        //*[@id="register-form3"]/div[2]/button
        JavascriptExecutor js4 = ((JavascriptExecutor) driver);
        js4.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//*[@id=\"register-form3\"]/div[2]/button")));
        //直系主管联系电话
        //*[@id="register-form3"]/div[1]/div[7]/input
        driver.findElement(By.xpath("//*[@id=\"register-form3\"]/div[1]/div[7]/input")).sendKeys("10000002014");
        driver.findElement(By.xpath("//*[@id=\"register-form3\"]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"register-form3\"]/div[2]/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"register-form3\"]/div[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"register-form4\"]/div[1]/div[2]/input")).sendKeys("自动化测试账号");
        driver.findElement(By.xpath("//*[@id=\"register-form4\"]/div[1]/div[3]/input")).sendKeys("自动化测试账号");
        Select sel8 = new Select(driver.findElement(By.xpath("//*[@id=\"register-form4\"]/div[1]/div[4]/select[1]")));
        sel8.selectByValue("1");
        Select sel9 = new Select(driver.findElement(By.xpath("//*[@id=\"register-form4\"]/div[1]/div[4]/select[2]")));
        sel9.selectByValue("2014");
        driver.findElement(By.xpath("//*[@id=\"register-form4\"]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"register-form4\"]/div[2]/div[1]")).click();
        Thread.sleep(1000);
//        JavascriptExecutor js4 = ((JavascriptExecutor) driver);
//        js4.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"register-form4\"]/div[2]/button")));
        //*[@id="register-form4"]/div[2]/button
        driver.findElement(By.xpath("//*[@id=\"register-form4\"]/div[2]/button")).click();
        Thread.sleep(1000);
        WebElement quitle = driver.findElement(By.xpath("//*[@id=\"submit-success\"]/div/div[1]/h3"));
        if (quitle == null) {
            logger.debug("全职老师报名失败");
        } else {
            logger.debug("全职老师报名成功2");
        }
        driver.navigate().refresh();
    }
}
