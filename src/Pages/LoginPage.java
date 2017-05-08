package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(xpath = "//input[@id='txtUsername']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='txtPassword']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='btnLogin']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//a[.='Welcome Admin']")
	private WebElement loggedInUser;
	
	public String verifyUser()
	{
		return loggedInUser.getText();
	}
	
	public LoginPage(WebDriver driver)
	{
		//This initelements method is used to create all webelements on this page
		PageFactory.initElements(driver, this);
	}
	
	public void login()
	{
		//enter user name
		username.sendKeys(ReadInputProperties.GetValue("username"));
		
		//enter password
		password.sendKeys(ReadInputProperties.GetValue("password"));
		
		//click on login
		loginBtn.click();
	}
}
