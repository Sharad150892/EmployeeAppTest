package testData;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void performLogin() throws InterruptedException {
		
		loginPage.enterEmail("narmsync.test@gmail.com");
		loginPage.enterPassword("12345678");
		loginPage.loginClick();
		Thread.sleep(3000);
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, " Login Succesfully");
	}
	
	@Test(priority=2)
	public void verifyHomePage() throws InterruptedException {
		homePage = loginPage.allowButton();
		String business = homePage.getBusinessName();
		Assert.assertEquals(business, "Look's Salon");
		String employee = homePage.getEmployeeName();
		Assert.assertEquals(employee, "Hi Ronald");
		homePage.notificationBell();
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void verifyDashboard() throws InterruptedException {
		dashboardPage = homePage.gotoDashboard();
		dashboardPage.swipe();
		Thread.sleep(2000);
		Assert.assertEquals(dashboardPage.getServiceRevenue(), "$0.00");
		Assert.assertEquals(dashboardPage.getNoOfAppointment(), "1");
		Assert.assertEquals(dashboardPage.getCompletedAppointment(), "0");
		Assert.assertEquals(dashboardPage.getCancelledAppointment(), "0");
		Assert.assertEquals(dashboardPage.getNoShowAppointment(), "1");
	}
	
	@Test(priority=4)
	public void verifyMyAccount() throws InterruptedException {
		myAccountPage = dashboardPage.clickMyAccount();
		myAccountPage.verifyEmpProfile();
		Assert.assertEquals(myAccountPage.verifyEmployeeName(), "Ronald");
		Assert.assertEquals(myAccountPage.verifyEmployeeEmail(), "narmsync.test@gmail.com");
		Assert.assertEquals(myAccountPage.verifyEmployeeNumber(), "(805) 551-2741");
//		System.out.println(myAccountPage.verifyService());
		Thread.sleep(1000);
		myAccountPage.swipeServiceAction();
	}
}
