package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditEmployee 
{	
	@FindBy(xpath = "//input[@value='Edit']")
	public WebElement editBtn;
	
	@FindBy(xpath = "//input[@id='personal_optGender_1']")
	private WebElement gender;
	
	@FindBy(xpath = "//select[@id='personal_cmbMarital']")
	private WebElement MaritalStatus;
	
	@FindBy(xpath = "//select[@id='personal_cmbNation']")
	private WebElement Nationality;
	
	@FindBy(xpath = "//input[@id='personal_DOB']")
	private WebElement DOBField;
	
//	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
//	private WebElement DOB_Year; 
//	
//	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
//	private WebElement DOB_Month;
	
	@FindBy(xpath = "//h1[.='Personal Details']")
	private WebElement persoanlDetailsLabel;
	
	public String verifyUpdatedDetails()
	{
		return persoanlDetailsLabel.getText();  
	}
	
	public EditEmployee(WebDriver driver)
	{
		//This initelements method is used to create all webelements on this page
		PageFactory.initElements(driver, this);
	}
	
	public void editPersonalDetails()
	{
		//click on edit button
		editBtn.click();
		
		//select gender
		gender.click();
		
		//select marital status
		Select selMarital = new Select(MaritalStatus);
		selMarital.selectByValue(ReadInputProperties.GetValue("Marital_Status"));
		
		//select nationality
		Select selNation = new Select(Nationality);
		selNation.selectByVisibleText(ReadInputProperties.GetValue("Nationality"));
		
		//enter DOB
		DOBField.clear();
		DOBField.sendKeys(ReadInputProperties.GetValue("DOB"));
	}
}
