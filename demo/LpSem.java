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
 * Created by Administrator on 2017/4/19.
 */
public class LpSem {
    private static Log logger = LogFactory.getLog(LpSem.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver = new ChromeDriver();
        // 打开连接
        driver.get("http://v2-test.zm1v1.com/lp/sem");
        driver.manage().window().maximize();
        //青少年在线教育，免费试听
        String mobile = "15121212136";
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("LpSem页面getFreeLesson 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson1(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("LpSem页面getFreeLesson1 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson2(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("LpSem页面getFreeLesson2 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson3(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("LpSem页面getFreeLesson3 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson4(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("LpSem页面getFreeLesson4 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson5(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("LpSem页面getFreeLesson5 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson6(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("LpSem页面getFreeLesson6 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson7(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("LpSem页面getFreeLesson7 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson8(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("LpSem页面getFreeLesson8 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson9(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("LpSem页面getFreeLesson9 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        try {
            getFreeLesson10(driver,mobile);
        } catch (Exception e) {
            System.out.println("出异常了 = [" + args + "]");
            logger.error("LpSem页面getFreeLesson10 出异常了");
        }
        DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
        driver.quit();
    }

    private static void getFreeLesson(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        //点击lp/sem页面第一个免费试听
        //*[@id="pcheaderbtn1"]/a
        driver.findElement(By.xpath("//*[@id=\"pcheaderbtn1\"]/a")).click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"stu-grade\"]")));
        sel.selectByValue("小三");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[3]/select[2]")));
        sel2.selectByValue("奥数");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"getFreeLesson\"]")).click();
        Thread.sleep(3000);
        // 点击预约成功的蒙版
        //*[@id="reservation-success"]/div/div
        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/div")).click();
        logger.debug("lp/sem页面，第1个0元试听成功！");
    }
    private static void getFreeLesson1(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/lp/sem");
        //点击第二个报名按钮
        //*[@id="teacherTeam"]/div/div/div[2]/a
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"teacherTeam\"]/div"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"teacherTeam\"]/div/div/div[2]/a");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"stu-grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[3]/select[2]")));
        sel2.selectByValue("物理");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"getFreeLesson\"]")).click();
        Thread.sleep(3000);
        // 点击预约成功的蒙版
        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/div")).click();
        logger.debug("lp/sem页面，第2个0元试听成功！");
    }
    private static void getFreeLesson2(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/lp/sem");
        //点击第三个报名按钮
        //*[@id="goodReason"]/div[3]/a
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"goodReason\"]/div[3]/a"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"goodReason\"]/div[3]/a");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"stu-grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[3]/select[2]")));
        sel2.selectByValue("物理");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"getFreeLesson\"]")).click();
        Thread.sleep(3000);
        // 点击预约成功的蒙版
        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/div")).click();
        logger.debug("lp/sem页面，第3个0元试听成功！");
    }
    private static void getFreeLesson3(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/lp/sem");
        //点击第四个报名按钮
        //*[@id="device"]/div/div[4]/a
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"device\"]/div"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"device\"]/div/div[4]/a");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"stu-grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[3]/select[2]")));
        sel2.selectByValue("物理");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"getFreeLesson\"]")).click();
        Thread.sleep(3000);
        // 点击预约成功的蒙版
        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/div")).click();
        logger.debug("lp/sem页面，第4个0元试听成功！");
    }
    private static void getFreeLesson4(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/lp/sem");
        //点击第五个报名按钮
        //*[@id="threeStudents"]/div/div[2]/a
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"threeStudents\"]/div"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"threeStudents\"]/div/div[2]/a");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"stu-grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[3]/select[2]")));
        sel2.selectByValue("物理");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"getFreeLesson\"]")).click();
        Thread.sleep(3000);
        // 点击预约成功的蒙版
        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/div")).click();
        logger.debug("lp/sem页面，第5个0元试听成功！");
    }
    private static void getFreeLesson5(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/lp/sem");
        //点击第六个报名按钮
        //*[@id="students-record"]/div/h2
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"students-record\"]/div/h2"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"studyPlan\"]/div/div[4]/a");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"stu-grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[3]/select[2]")));
        sel2.selectByValue("物理");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"getFreeLesson\"]")).click();
        Thread.sleep(3000);
        // 点击预约成功的蒙版
        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/div")).click();
        logger.debug("lp/sem页面，第6个0元试听成功！");
    }
    private static void getFreeLesson6(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/lp/sem");
        //点击第七个报名按钮
        //*[@id="students-record2"]/div/h2
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"students-record2\"]/div/h2"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"students-record\"]/div/div[4]/a[2]");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"stu-grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[3]/select[2]")));
        sel2.selectByValue("物理");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"getFreeLesson\"]")).click();
        Thread.sleep(3000);
        // 点击预约成功的蒙版
        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/div")).click();
        logger.debug("lp/sem页面，第7个0元试听成功！");
    }
    private static void getFreeLesson7(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/lp/sem");
        //点击第八个报名按钮
        //*[@id="guarantee"]/div/div[1]/h2
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"guarantee\"]/div/div[1]/h2"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"students-record2\"]/div/div[3]/div[2]/a");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"stu-grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[3]/select[2]")));
        sel2.selectByValue("物理");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"getFreeLesson\"]")).click();
        Thread.sleep(3000);
        // 点击预约成功的蒙版
        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/div")).click();
        logger.debug("lp/sem页面，第8个0元试听成功！");
    }
    private static void getFreeLesson8(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/lp/sem");
        //点击第九个报名按钮
        //*[@id="zm-medal"]/div/div/h3
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"zm-medal\"]/div/div/h3"))); //先定位到父级的div
        Thread.sleep(1000);
        By by = By.xpath("//*[@id=\"guarantee\"]/div/div[4]/a");  //然后才能点击
        WebElement element = driver.findElement(by);
        element.click();
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/div[1]/input")).sendKeys(mobile);
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"stu-grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[3]/select[2]")));
        sel2.selectByValue("物理");
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"getFreeLesson\"]")).click();
        Thread.sleep(3000);
        // 点击预约成功的蒙版
        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/div")).click();
        logger.debug("lp/sem页面，第9个0元试听成功！");
    }
    private static void getFreeLesson9(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/lp/sem");
        //点击第十个报名按钮
        //*[@id="pcfooterbtn"]
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"guarantee\"]/div/div[4]/a"))); //先定位到父级的div
        Thread.sleep(3000);
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"subscribe-foot\"]/div[2]/div[2]/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //选择年级
        //*[@id="grade"]
//        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
//        sel.selectByValue("初一");
//        //选择科目
//        //*[@id="weak_subject"]
//        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
//        sel2.selectByValue("物理");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"stu_mobile2\"]")).sendKeys(mobile);
        //点击提交按钮
        //*[@id="pcfooterbtn"]
        driver.findElement(By.xpath("//*[@id=\"pcfooterbtn\"]")).click();
        Thread.sleep(2000);
        String strUrl2 = "https://v2-test.zm1v1.com/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("lp/sem页面，第10个0元试听成功！");
        }else{
            logger.debug("lp/sem页面，第10个0元试听失败！");
        }
        driver.navigate().back();
        driver.navigate().refresh();
    }
    private static void getFreeLesson10(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        driver.get("http://v2-test.zm1v1.com/lp/sem");
        //点击第十一个报名按钮
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"s-name\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"s-name\"]")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"grade\"]")));
        sel.selectByValue("初一");
        //选择科目
        Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"weak_subject\"]")));
        sel2.selectByValue("物理");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"stu_mobile1\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"stu_mobile1\"]")).sendKeys(mobile);
        //点击提交按钮
        driver.findElement(By.xpath("//*[@id=\"pcheaderbtn2\"]")).click();
        Thread.sleep(2000);
        String strUrl2 = "https://v2-test.zm1v1.com/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("lp/sem页面，第11个0元试听成功！");
        }else{
            logger.debug("lp/sem页面，第11个0元试听失败！");
        }
        driver.navigate().back();
        driver.navigate().refresh();
    }
}
