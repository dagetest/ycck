package com.sele.demo;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Element;


/**
 * Created by Administrator on 2017/3/8.
 */
public class GuanWangShouYe {
    private static Log logger = LogFactory.getLog(GuanWangShouYe.class); //打印日志
    public static void main(String[] args) throws InterruptedException {
        // 浏览器文件地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 打开一个新的页面
        WebDriver driver = new ChromeDriver();
        // 打开连接
        driver.get("https://v2-test.zm1v1.com/");
        driver.manage().window().maximize();
        //免费试听
        String mobile = "15121212101";
//        WebElement tipHelp = null;
//        WebDriverWait wait = new WebDriverWait(driver, 15);
//        wait.until(new ExpectedCondition<WebElement>(){
//            @Override
//            public WebElement apply(WebDriver d) {
//                return d.findElement(By.xpath("//*[@id=\"js-submit-btn\"]"));
//            }}).click();
////        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"js-tip-title\"]"));
////        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[@id=\"js-tip-title\"]"))));
////        WebElement element = driver.findElement(By.xpath("//*[@id=\"js-cancle-btn\"]"));
////        element .click();

        //调用下边的弹窗函数
//        for (int i = 0; i < 10; i++) {
            DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
            try {
                getFreeLesson(driver, mobile);
            } catch (Exception e) {
                System.out.println("出异常了 = [" + args + "]");
                logger.error("官网首页getFreeLesson出异常了");
            }
            DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
            try {
                getFreeLesson1(driver, mobile);
            } catch (Exception e) {
                System.out.println("出异常了 = [" + args + "]");
                logger.error("官网首页getFreeLesson1出异常了");
            }
            DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
            try {
                getFreeLesson2(driver, mobile);
            } catch (Exception e) {
                System.out.println("出异常了 = [" + args + "]");
                logger.error("官网首页getFreeLesson2出异常了");
            }
            DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
            try {
                getFreeLesson3(driver, mobile);
            } catch (Exception e) {
                System.out.println("出异常了 = [" + args + "]");
                logger.error("官网首页getFreeLesson3出异常了");
            }
            DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
            try {
                getFreeLesson4(driver, mobile);
            } catch (Exception e) {
                System.out.println("出异常了 = [" + args + "]");
                logger.error("官网首页getFreeLesson4出异常了");
            }
            DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
            try {
                getFreeLesson5(driver, mobile);
            } catch (Exception e) {
                System.out.println("出异常了 = [" + args + "]");
                logger.error("官网首页getFreeLesson5出异常了");
            }
            DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
            try {
                getFreeLesson6(driver, mobile);
            } catch (Exception e) {
                System.out.println("出异常了 = [" + args + "]");
                logger.error("官网首页getFreeLesson6出异常了");
            }
            DBTools4Student.allowDuplicateRegiste(mobile);//清除手机号
            driver.quit();
//        }
    }
    private static void getFreeLesson(WebDriver driver,String mobile) throws InterruptedException {      // private 私有类
        // driver是驱动程序，findElement 查找页面元素  使用By.Xpath快速定位页面元素
        driver.findElement(By.xpath("//*[@id=\"banner\"]/div/div[1]/div/div/div/a")).click();
        // \"reservation"\  \\是转义字符
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/select[1]")));
        sel.selectByValue("高二");
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
            logger.debug("官网首页，第1个0元试听失败！");
        }else{
            logger.debug("官网首页，第1个0元试听成功！");
        }
//        driver.navigate().back();
//        Thread.sleep(1000);
//        driver.navigate().refresh();
//        Thread.sleep(2000);
//        // 点击预约成功的蒙版
//        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/h2")).click();
//        Thread.sleep(2000);
//        //退出操作
//        driver.findElement(By.xpath("//*[@id=\"n-top-bar\"]/div/div[2]/a[3]/b")).click();
    }
    private static void getFreeLesson1(WebDriver driver,String mobile)  throws Exception{
           driver.get("https://v2-test.zm1v1.com/");
            //WebElement btn = driver.findElement(By.xpath("//*[@id=\"teachPosition\"]/div/div[1]/a"));
            //((JavascriptExecutor)driver).executeScript("arguments[0].click();", btn);
            //先定位到父级的div，然后才能点击
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"teachPosition\"]/div"))); //先定位到父级的div
            By by = By.xpath("//*[@id=\"teachPosition\"]/div/div[1]/a");  //然后才能点击
            WebElement element = driver.findElement(by);
            element.click();
            //点击第二个免费试听按钮
            //driver.findElement(By.xpath("//*[@id=\"teachPosition\"]/div/div[1]/a")).click();
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
                logger.debug("官网首页，第2个0元试听失败！");
            }else{
                logger.debug("官网首页，第2个0元试听成功！");
            }
//        driver.navigate().back();
//        Thread.sleep(1000);
//        driver.navigate().refresh();
//        Thread.sleep(2000);
//        // 点击预约成功的蒙版
//        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/h2")).click();
//        Thread.sleep(2000);
//        //退出操作
//        driver.findElement(By.xpath("//*[@id=\"n-top-bar\"]/div/div[2]/a[3]/b")).click();
    }
    private static void getFreeLesson2(WebDriver driver,String mobile) throws InterruptedException {
        driver.get("https://v2-test.zm1v1.com/");
//        // 点击预约成功的蒙版
//        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/h2")).click();
//        Thread.sleep(2000);
//        //退出操作
//        driver.findElement(By.xpath("//*[@id=\"n-top-bar\"]/div/div[2]/a[3]/b")).click();
        //*[@id="video"]/div/div[2]/a
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"video\"]/div")));
        By by = By.xpath("//*[@id=\"video\"]/div/div[2]/a");
        WebElement element = driver.findElement(by);
        element.click();
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
        //点击0元试听按钮
        driver.findElement(By.id("getFreeLesson")).click();
        Thread.sleep(2000);
        String strUrl2 = "https://v2-test.zm1v1.com/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("官网首页，第3个0元试听失败！");
        }else{
            logger.debug("官网首页，第3个0元试听成功！");
        }
//        driver.navigate().back();
//        Thread.sleep(1000);
//        driver.navigate().refresh();
//        Thread.sleep(2000);
//        // 点击预约成功的蒙版
//        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/h2")).click();
//        Thread.sleep(2000);
//        //退出操作
//        driver.findElement(By.xpath("//*[@id=\"n-top-bar\"]/div/div[2]/a[3]/b")).click();
    }
    private static void getFreeLesson3(WebDriver driver,String mobile) throws InterruptedException {
        driver.get("https://v2-test.zm1v1.com/");

        //*[@id="exClusiveSystem"]/div/div[2]/div/a
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"exClusiveSystem\"]/div")));
        Thread.sleep(5000);
        By by = By.xpath("//*[@id=\"exClusiveSystem\"]/div/div[2]/div/a");
        WebElement element = driver.findElement(by);
        element.click();
        //点击第四个免费试听按钮
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/select[1]")));
        sel.selectByValue("高二");
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
            logger.debug("官网首页，第4个0元试听失败！");
        }else{
            logger.debug("官网首页，第4个0元试听成功！");
        }
//        driver.navigate().back();
//        Thread.sleep(1000);
//        driver.navigate().refresh();
//        Thread.sleep(2000);
        // 点击预约成功的蒙版
        //*[@id="reservation-success"]/div/h2
//        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/h2")).click();
//        Thread.sleep(2000);
//        //退出操作
//        driver.findElement(By.xpath("//*[@id=\"n-top-bar\"]/div/div[2]/a[3]/b")).click();
        Thread.sleep(2000);
    }
    private static void getFreeLesson4(WebDriver driver,String mobile) throws InterruptedException {
        driver.get("https://v2-test.zm1v1.com/");

        //*[@id="animationInteraction"]/div/div[1]/a
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"animationInteraction\"]/div")));
        By by = By.xpath("//*[@id=\"animationInteraction\"]/div/div[1]/a");
        WebElement element = driver.findElement(by);
        element.click();
        //点击第五个免费试听按钮
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/select[1]")));
        sel.selectByValue("高二");
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
            logger.debug("官网首页，第5个0元试听失败！");
        }else{
            logger.debug("官网首页，第5个0元试听成功！");
        }
//        driver.navigate().back();
//        Thread.sleep(1000);
//        driver.navigate().refresh();
//        Thread.sleep(2000);
//        // 点击预约成功的蒙版
//        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/h2")).click();
//        Thread.sleep(2000);
//        //退出操作
//        driver.findElement(By.xpath("//*[@id=\"n-top-bar\"]/div/div[2]/a[3]/b")).click();
    }
    private static void getFreeLesson5(WebDriver driver,String mobile) throws InterruptedException {
        driver.get("https://v2-test.zm1v1.com/");

        //*[@id="starRecommend"]/div/a
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"starRecommend\"]/div")));
        By by = By.xpath("//*[@id=\"starRecommend\"]/div/a");
        WebElement element = driver.findElement(by);
        element.click();
        //点击第六个免费试听按钮
        driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[1]/div[1]/input")).sendKeys("自动化测试账号");
        //选择年级
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"reservation\"]/div[1]/div/form[1]/div[1]/div/div[2]/select[1]")));
        sel.selectByValue("高二");
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
            logger.debug("官网首页，第6个0元试听失败！");
        }else{
            logger.debug("官网首页，第6个0元试听成功！");
        }
//        driver.navigate().back();
//        Thread.sleep(1000);
//        driver.navigate().refresh();
//        Thread.sleep(2000);
        // 点击预约成功的蒙版
//        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/h2")).click();
//        Thread.sleep(2000);
//        //退出操作
//        driver.findElement(By.xpath("//*[@id=\"n-top-bar\"]/div/div[2]/a[3]/b")).click();
    }
    private static void getFreeLesson6(WebDriver driver,String mobile) throws InterruptedException {
        driver.get("https://v2-test.zm1v1.com/");

        //点击第七个免费试听按钮
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
        //*[@id="reservation-bar"]/form/div[5]/button
        driver.findElement(By.xpath("//*[@id=\"reservation-bar\"]/form/div[5]/button")).click();
        Thread.sleep(2000);
        String strUrl2 = "https://v2-test.zm1v1.com/appointment-success";
        if(strUrl2.equals(driver.getCurrentUrl())){
            logger.debug("官网首页，第7个0元试听失败！");
        }else{
            logger.debug("官网首页，第7个0元试听成功！");
        }
//        driver.navigate().back();
//        Thread.sleep(1000);
//        driver.navigate().refresh();
//        Thread.sleep(2000);
//        // 点击预约成功的蒙版
//        driver.findElement(By.xpath("//*[@id=\"reservation-success\"]/div/h2")).click();
//        Thread.sleep(2000);
//        //退出操作
//        driver.findElement(By.xpath("//*[@id=\"n-top-bar\"]/div/div[2]/a[3]/b")).click();
    }
}










