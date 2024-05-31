package onlytestingblogwebsite;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class onlytestingblogwebsite {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String mainwindow=driver.getWindowHandle();
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(30)); 
		
		WebElement Firstname=driver.findElement(By.xpath("//input[@id='text1']"));

		mywait.until(ExpectedConditions.elementToBeClickable(Firstname));
		Firstname.sendKeys("KANTHI");
		Thread.sleep(2500);
	
//		WebElement Lastname=driver.findElement(By.xpath("//input[@id='text2']"));
//		mywait.until(ExpectedConditions.elementToBeClickable(Firstname)).isEnabled();
//		boolean actualvalue=Lastname.isEnabled();
//		if(actualvalue == true) {
//			Lastname.sendKeys("sri");
//		}
//
//		WebElement Hidden=driver.findElement(By.xpath("//input[@id='text3']"));
//		Hidden.sendKeys("This is an hidden item");
//		
		WebElement Bike=driver.findElement(By.xpath("//input[@id='check1']"));
		Bike.click();
		WebElement Car=driver.findElement(By.xpath("//input[@id='check2']"));
		Car.click();
		WebElement Boat=driver.findElement(By.xpath("//input[@id='check3']"));
		Boat.click();
		WebElement Femalebtn=driver.findElement(By.xpath("//input[@id='radio2']"));
		Femalebtn.click();
		WebElement Chooseafile=driver.findElement(By.xpath("//input[@name='img']"));
		Chooseafile.sendKeys("C:\\Users\\chakr\\Desktop\\Project .png");
		
		WebElement Selectbox=driver.findElement(By.xpath("//select[@id='Carlist']"));
		Select select= new Select(Selectbox);
		select.selectByVisibleText("Toyota");
		
		WebElement Selectcountry=driver.findElement(By.xpath("//select[@name='FromLB']"));
		Select select1= new Select(Selectcountry);
		select1.selectByVisibleText("   France   ");
		WebElement inputarrow=driver.findElement(By.xpath("//input[@value='->']"));
		inputarrow.click();
		select1.selectByVisibleText("Greece");
		inputarrow.click();
		select1.selectByVisibleText("Italy");
		inputarrow.click();
		select1.selectByVisibleText("Malaysia");
		inputarrow.click();
		WebElement outputarrow=driver.findElement(By.xpath("//input[@value='<-']"));
		driver.findElement(By.xpath("//option[@value='Malaysia']")).click();
		outputarrow.click();
		
		WebElement showmeconfirmation=driver.findElement(By.xpath("//button[text()='Show Me Confirmation']"));
		showmeconfirmation.click();
		System.out.println("Firstalert box msg is:"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		WebElement confirmationmsg=driver.findElement(By.xpath("//div[@id='demo']"));
		System.out.println("Alert confiramtion msg is:"+confirmationmsg.getText());
		WebElement showmealert=driver.findElement(By.xpath("//input[@value='Show Me Alert']"));
		showmealert.click();
		System.out.println("Second alert box msg is:"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		WebElement showmeprompt=driver.findElement(By.xpath("//button[text()='Show Me Prompt']"));
		showmeprompt.click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("kanthi");//it's not sending the text in the text box
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		WebElement numbertable=driver.findElement(By.xpath("//body/div/div/div/div/div/div/div/div/div/div/div/div[@id='main']/div[@id='Blog1']/div/div/div/div/div[@itemprop='blogPost']/div[@id='post-body-4292417847084983089']/div[@dir='ltr']/table[1]"));
		List <WebElement> tablerows=driver.findElements(By.xpath("//body/div/div/div/div/div/div/div/div/div/div/div/div[@id='main']/div[@id='Blog1']/div/div/div/div/div[@itemprop='blogPost']/div[@id='post-body-4292417847084983089']/div[@dir='ltr']/table[1]//tr"));
		for (WebElement webElement : tablerows) {
			System.out.println(webElement.getText());
			
		}
		
		WebElement opennewpage=driver.findElement(By.xpath("//b[text()='Open New Page']"));
		opennewpage.click();
        System.out.println("Clicked on open webpage");
		
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		Thread.sleep(1500);
		driver.close();
		System.out.println("open webpage got closed");
		driver.switchTo().window(mainwindow);
		
		WebElement emailicon=driver.findElement(By.xpath("//span[text()='Email This']"));
		emailicon.click();
		System.out.println("Clicked on Email icon");
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		Thread.sleep(1500);
		driver.close();
		System.out.println("Email icon page got closed");
		driver.switchTo().window(mainwindow);
		
		WebElement BlogThis=driver.findElement(By.xpath("//span[text()='BlogThis!']"));
		BlogThis.click();
		System.out.println("Clicked on blogger icon");
		Set<String> handles= driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(mainwindow)) {
				driver.switchTo().window(handle);
				driver.close();
				System.out.println("blogger icon page got closed");
				
			}
			
		}
		driver.switchTo().window(mainwindow);
		WebElement Twitter=driver.findElement(By.xpath("//span[text()='Share to Twitter']"));
		Twitter.click();
		System.out.println("Clicked on Twitter icon");
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		Thread.sleep(1500);
		driver.close();
		System.out.println("Twitter page got closed");
		driver.switchTo().window(mainwindow);
		
		
		WebElement Facebook=driver.findElement(By.xpath("//span[text()='Share to Facebook']"));
		Facebook.click();
		System.out.println("Clicked on Facebook icon ");
		Set<String> handles1= driver.getWindowHandles();
		for (String handle : handles1) {
			System.out.println(handle);
			if(!handle.equals(mainwindow)) {
				driver.switchTo().window(handle);
				driver.close();
				System.out.println("Facebook page got closed");
				
			}
			
		}
		
		driver.switchTo().window(mainwindow);
		WebElement Pinterest=driver.findElement(By.xpath("//span[text()='Share to Pinterest']"));
		Pinterest.click();
		System.out.println("Clicked on Pinterest icon");
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		Thread.sleep(1500);
		driver.close();
		System.out.println("Pinterest page got closed");
		driver.switchTo().window(mainwindow);
		
		//Home link
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='Facebook']")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//img[@id='Image1_img']")).click();
		driver.findElement(By.xpath("//span[text()='Free Trial']")).click();
		System.out.println("Clicked on Browser stack icon");
		driver.navigate().back();
		driver.navigate().back();
		driver.quit();
		
	}

}
