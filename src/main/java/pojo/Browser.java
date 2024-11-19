package pojo;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public static WebDriver OpenBrowser()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000)); //Univarsal
		
		return driver;
	}

}
