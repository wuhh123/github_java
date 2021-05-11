import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class UI_autoTest001 {
    //指定本机Chrome的安装路径，注意版本匹配。
    private static final String DRIVER_PATH=Thread.currentThread().getContextClassLoader().getResource("").getPath()+"chromedriver.exe";
    private static final String BROWSER_PATH="C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
    public static <webDriver> void main(String[] args)throws IOException{
        //可通过chromedriverservice中配置chromedriver.exe的路径。
        ChromeDriverService service=new ChromeDriverService.Builder().usingDriverExecutable(new File(DRIVER_PATH)).usingAnyFreePort().build();
//        ChromeDriverService service=new chromeDriverSevice.Builder().usingDriverExecutable(new File(DRIVER_PATH)).usingAnyFreePort().build();
        //可通过ChromeOptions中配置Chrome的安装路径。
        ChromeOptions options=new ChromeOptions().setBinary(new File("BROWSER_PATH"));
        //可通过配置ChromeDriverService\ChromeOptions,启动Chrome浏览器
        WebDriver driver=new ChromeDriver(service,options);
//        webDriver driver= (webDriver) new ChromeDriver(service,options);

//        driver.navigate.to("https://www.baidu.com/");
        //打开测试网站
        driver.get("http://www.baidu.com");
        //查找输入框的元素
        WebElement element=driver.findElement(By.id("kw"));
        //输入“你好，京东！”并提交
        element.sendKeys("你好，京东！");
        element.submit();
//        //等待页面加载，知道出现期望元素，如果超过10s抛出异常
//        new WebDriverWait(driver,10).until(new ExceptionCondition<Boolean>(){
//            public Boolean apply(WebDriver d){
//                return d.getTitle().toLowerCase().startsWith("你好，京东");
//            }
//        });

        //输出页面标题
        System.out.println("Page title is:"+driver.getTitle());

        //关闭浏览器
        driver.close();
        //关闭当前窗口
        driver.quit();
    }
}
