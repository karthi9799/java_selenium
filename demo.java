package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {

	public static void main(String[] args) throws InterruptedException {
		System.out.print("hello");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\iambh\\Downloads\\myfiles\\exe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.gmail.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("identifierId")).sendKeys("electronkarthiece@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		Thread.sleep(2000);
		String at = driver.getTitle();
		String et = "gmail";
		driver.close();
		if(at.equalsIgnoreCase(et))
		{
			System.out.print("pass");
		}
		else
		{
			System.out.print("fail");
		}
		}

}
