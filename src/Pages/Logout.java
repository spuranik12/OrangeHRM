package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.Base;

public class Logout
{ 
	LoginPage objLogin;
	
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logoutLink;
	
	public Logout(WebDriver driver)
	{
		//This initelements method is used to create all webelements on this page
		PageFactory.initElements(driver, this);
	}
	
	public void logout() throws InterruptedException
	{
		//click on welcome link
		objLogin = new LoginPage(Base.driver);
		objLogin.loggedInUser.click();
		
		//click on logout link
		Thread.sleep(1000);
		logoutLink.click();
	}
}
