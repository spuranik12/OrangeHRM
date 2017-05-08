package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployee 
{
	@FindBy(xpath = "//b[.='PIM']")
	private WebElement PIMlink;
	
	@FindBy(xpath = "//a[.='Add Employee']")
	private WebElement addEmpLink;
	
	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement LastName;
	
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement saveBtn;
	
	@FindBy(xpath = "//h1[.='Amit Ganguly']")
	private WebElement EmpName;
	
	public String verifyAddEmp()
	{
		return EmpName.getText(); 
	}
	
	public AddEmployee(WebDriver driver)
	{
		//This initelements method is used to create all webelements on this page
		PageFactory.initElements(driver, this);
	}
	
	public void OpenAddEmpPage()
	{
		//click on PIM Link
		PIMlink.click();
		
		//click on add employee link
		addEmpLink.click();
	}
	
	public void addEmpDetails()
	{
		//enter first name
		firstName.sendKeys(ReadInputProperties.GetValue("FirstName"));
		
		//enter last name
		LastName.sendKeys(ReadInputProperties.GetValue("LastName"));
	}
	
	public void saveDetails()
	{
		saveBtn.click();
	}
}
