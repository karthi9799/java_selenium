package demo;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class demo {

	public static void main(String[] args) throws InterruptedException, TesseractException {
		// TODO Auto-generated method stub
		System.out.print("hello");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\iambh\\Downloads\\myfiles\\exe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://my.swissbankers.ch/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("UserName")).sendKeys("electronkarthiece@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Karthi@9799");
		WebElement imageElement = driver.findElement(By.xpath("//*[@id=\"img-captcha\"]"));
		
		// Take a screenshot of the image element
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// Use Tesseract OCR to extract text from the image
		ITesseract tesseract = new Tesseract();
		String text = tesseract.doOCR(screenshot);
		
		// Output the extracted text
		System.out.println(text);
		Thread.sleep(2000);
		
		driver.findElement(By.id("CaptchaCodeEntered")).sendKeys(text);
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		//String at = driver.getTitle();
		//String et = "gmail";
		driver.close();
		//if(at.equalsIgnoreCase(et))
		/*{
			System.out.print("pass");
		}
		else
		{
			System.out.print("fail");
		}*/
		}

}
