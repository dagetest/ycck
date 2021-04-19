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
public class MobileTeacherRegister {
    private static Log logger = LogFactory.getLog(MobileTeacherRegister.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
//        for(int i = 0; i< 20; i++){
            // 浏览器文件地址
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
            // 打开一个新的页面
            WebDriver driver = new ChromeDriver();
            driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?winzoom=1");
            driver.manage().window().maximize();
            String mobile = "15121212143";
            DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?winzoom=1");
            logger.error("MobileTeacherRegister页面getFreeLesson 出异常了");
        }
            DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson1(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("MobileTeacherRegister页面getFreeLesson1 出异常了");
        }
            DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号

        driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?from=%E6%9D%A8%E5%B8%86");
        try {
            getFreeLesson2(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("MobileTeacherRegister页面getFreeLesson2 出异常了");
        }
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?from=%E6%9D%A8%E5%B8%86");
        try {
            getFreeLesson3(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("MobileTeacherRegister页面getFreeLesson3 出异常了");
        }
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?from=%E6%B5%8B%E8%AF%952222");
        getFreeLesson2(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        getFreeLesson3(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?from=%E4%BB%A3%E7%90%86112");
        getFreeLesson2(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        getFreeLesson3(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?from=%E6%B5%8B%E8%AF%9599");
        getFreeLesson2(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        getFreeLesson3(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?from=%E7%8E%8B%E9%B8%BF%E9%9B%81");
        getFreeLesson2(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        getFreeLesson3(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?from=%E6%9D%A8%E6%9F%B3");
        getFreeLesson2(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        getFreeLesson3(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?from=%E6%9D%A8%E6%9F%B3%EF%BC%88%E7%89%A9%E7%90%86%EF%BC%89");
        getFreeLesson2(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        getFreeLesson3(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?from=%E8%8B%97%E5%BF%97%E4%BA%AE");
        getFreeLesson2(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        getFreeLesson3(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?from=%E5%A4%8F%E6%98%8A");
        getFreeLesson2(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        getFreeLesson3(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?from=%E6%9D%A8%E5%85%89");
        getFreeLesson2(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        getFreeLesson3(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        driver.get("http://v2-test.zm1v1.com/mobile/teacher-register?from=%E5%88%98%E6%A2%A6%E9%9B%85");
        getFreeLesson2(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
        getFreeLesson3(driver,mobile); //调用下边的弹窗函数
        DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号

//            driver.get(Contact.getUrl(i));

//            getFreeLesson3(driver,mobile);
//            DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
//            getFreeLesson4(driver,mobile);
//            DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
//            getFreeLesson5(driver,mobile);
//            DBTools4Teacher.allowDuplicateRegiste(mobile);//清除手机号
            driver.quit();
    }
    private static void getFreeLesson(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //掌门讲师报名
        Thread.sleep(4000);
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
        //*[@id="goodFirst"]
        JavascriptExecutor js1 = ((JavascriptExecutor) driver);
        js1.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"goodFirst\"]")));
        //学校
        Select sel1 = new Select(driver.findElement(By.xpath("//*[@id=\"school\"]")));
        sel1.selectByValue("香港科技大学");
        //年级-本科生
        driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[6]/label/span/label[1]/input")).click();
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"tea_grade\"]")));
        sel2.selectByValue("2013级");
        //教学科目
        Select sel3 = new Select(driver.findElement(By.xpath("//*[@id=\"goodFirst\"]")));
        sel3.selectByValue("物理");
        //推介人
        //driver.findElement(By.xpath("//*[@id=\"referrer-mobile\"]")).sendKeys("10000002014");
        //面试科目高考分数
        driver.findElement(By.xpath("//*[@id=\"good-first-score\"]")).sendKeys("125");
        //相关竞赛获奖情况
        driver.findElement(By.xpath("//*[@id=\"tea_honor\"]")).sendKeys("自动化测试");
        //家教经验
        driver.findElement(By.xpath("//*[@id=\"tea_taught_stu_count\"]")).sendKeys("自动化测试");
        //*[@id="register-form"]/div[13]/button
        //*[@id="register-form"]/div[12]/button
        JavascriptExecutor js2= ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[13]/button")));
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[13]/button")).click();
        Thread.sleep(2000);
        logger.debug("公校兼职老师报名成功1");
        driver.navigate().refresh();
        Thread.sleep(2000);
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
        js1.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"school\"]")));
        //学校
        Select sel1 = new Select(driver.findElement(By.xpath("//*[@id=\"school\"]")));
        sel1.selectByValue("香港城市大学");
        //年级-研究生
        driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[6]/label/span/label[2]/input")).click();
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"tea_grade\"]")));
        sel2.selectByValue("2016级");
        //教学科目
        Select sel3 = new Select(driver.findElement(By.xpath("//*[@id=\"goodFirst\"]")));
        sel3.selectByValue("化学");
        //面试科目高考分数
        driver.findElement(By.xpath("//*[@id=\"good-first-score\"]")).sendKeys("125");
        JavascriptExecutor js2= ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[13]/button")));
        //相关竞赛获奖情况
        driver.findElement(By.xpath("//*[@id=\"tea_honor\"]")).sendKeys("自动化测试");
        //家教经验
        driver.findElement(By.xpath("//*[@id=\"tea_taught_stu_count\"]")).sendKeys("自动化测试");
        //推介人
        driver.findElement(By.xpath("//*[@id=\"referrer-mobile\"]")).sendKeys("10000002014");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[13]/button")).click();
        Thread.sleep(2000);
        logger.debug("公校兼职老师报名成功2");
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
    private static void getFreeLesson2(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
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
        js1.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[12]/button")));
        //学校
        Select sel1 = new Select(driver.findElement(By.xpath("//*[@id=\"school\"]")));
        sel1.selectByValue("厦门大学");
        //年级-本科生
        driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[6]/label/span/label[1]/input")).click();
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"tea_grade\"]")));
        sel2.selectByValue("2013级");
        //教学科目
        Select sel3 = new Select(driver.findElement(By.xpath("//*[@id=\"goodFirst\"]")));
        sel3.selectByValue("物理");
        //推介人
        //driver.findElement(By.xpath("//*[@id=\"referrer-mobile\"]")).sendKeys("10000002014");
        //面试科目高考分数
        driver.findElement(By.xpath("//*[@id=\"good-first-score\"]")).sendKeys("125");
        //相关竞赛获奖情况
        driver.findElement(By.xpath("//*[@id=\"tea_honor\"]")).sendKeys("自动化测试");
        //家教经验
        driver.findElement(By.xpath("//*[@id=\"tea_taught_stu_count\"]")).sendKeys("自动化测试");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[12]/button")).click();
        Thread.sleep(2000);
        logger.debug("公校兼职老师报名成功3");
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
    private static void getFreeLesson3(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
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
        js1.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[12]/button")));
        //学校
        Select sel1 = new Select(driver.findElement(By.xpath("//*[@id=\"school\"]")));
        sel1.selectByValue("厦门大学");
        //年级-研究生
        driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[6]/label/span/label[2]/input")).click();
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"tea_grade\"]")));
        sel2.selectByValue("2015级");
        //教学科目
        Select sel3 = new Select(driver.findElement(By.xpath("//*[@id=\"goodFirst\"]")));
        sel3.selectByValue("化学");
        //推介人
        //driver.findElement(By.xpath("//*[@id=\"referrer-mobile\"]")).sendKeys("10000002014");
        //面试科目高考分数
        driver.findElement(By.xpath("//*[@id=\"good-first-score\"]")).sendKeys("125");
        //相关竞赛获奖情况
        driver.findElement(By.xpath("//*[@id=\"tea_honor\"]")).sendKeys("自动化测试");
        //家教经验
        driver.findElement(By.xpath("//*[@id=\"tea_taught_stu_count\"]")).sendKeys("自动化测试");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[12]/button")).click();
        Thread.sleep(2000);
        logger.debug("公校兼职老师报名成功4");
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
}
