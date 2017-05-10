package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AddEmployee;
import Pages.EditEmployee;
import Pages.LoginPage;
import Pages.Logout;
import Pages.ReadInputProperties;

public class ExecuteTests extends Base
{
	LoginPage objLogin;
	AddEmployee objAddEmp;
	EditEmployee objEditEmp;
	Logout objLogout;
	
	@Test
	public void Login()
	{
		//create object of login page
		objLogin = new LoginPage(driver);
		
		objLogin.login();
		
		Assert.assertTrue(objLogin.verifyUser().contains(ReadInputProperties.GetValue("LoginUser")));
		System.out.println("Login Successfull.");
	}
	
	@Test(dependsOnMethods = "Login")
	public void CreateEmployee() 
	{
		objAddEmp = new AddEmployee(driver);
		
		objAddEmp.OpenAddEmpPage();
		objAddEmp.addEmpDetails();
		objAddEmp.saveDetails();
		
		Assert.assertTrue(objAddEmp.verifyAddEmp().contains(ReadInputProperties.GetValue("NewEmployee")));
		System.out.println("New Employee created successfully.");
	}
	
	@Test(dependsOnMethods = "CreateEmployee")
	public void UpdateEmployee() throws InterruptedException
	{
		objEditEmp = new EditEmployee(driver);
		
		objEditEmp.editPersonalDetails();
		
		//call save
		objAddEmp.saveDetails();
		
		Assert.assertTrue(objEditEmp.verifyUpdatedDetails().contains(ReadInputProperties.GetValue("Label")));
		System.out.println("Employee Details updated successfully..");
	}
	
	@Test(dependsOnMethods = "UpdateEmployee")
	public void LogOut() throws InterruptedException 
	{
		objLogout = new Logout(driver);
		
		Thread.sleep(2000);
		objLogout.logout();
	}
}
