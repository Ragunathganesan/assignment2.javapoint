package assignments;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaTpoint {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		
		driver.get(" http://www.javatpoint.com/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,500)");
		
		driver.findElementByXPath("(//img[@alt='cucumber tutorial'])").click();
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		WebElement logo = driver.findElementByXPath("//img[@class='imageright']");
		
		File screenFile = driver.getScreenshotAs(OutputType.FILE);
		
		BufferedImage fullImage = ImageIO.read(screenFile);
		
		Point location = logo.getLocation();
		
		int width = logo.getSize().getWidth();
		
		int height = logo.getSize().getHeight();
		
		BufferedImage subimage = fullImage.getSubimage(location.getX(), location.getY(), width, height);
		
		ImageIO.write(subimage, "png", screenFile);
		
		File store = new File("./snaps/cucumber.png");
		
		FileUtils.copyFile(screenFile, store);
		
		Thread.sleep(3000);
		
		driver.findElementByXPath("(//a[@class='next'])").click();
		
		driver.findElementByXPath("//a[text()='Behavior Driven Development']").click();
		
		driver.findElementByXPath("(//a[text()='← prev'])").click();
		
		String title2 = driver.getTitle();
		
		System.out.println("Webpage launched ---"+title2);
		
		
			
		}
		

	}
	
	


