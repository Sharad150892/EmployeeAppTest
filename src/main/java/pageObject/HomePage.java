package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidAction;

public class HomePage extends AndroidAction{
	
	AndroidDriver driver;
	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/tvBusinessName")
	private WebElement businessName;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/tvTitleName")
	private WebElement employeeName;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/ivImage")
	private WebElement notificationBell;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/iv_back")
	private WebElement notificationback;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/btndashboard")
	private WebElement dashboard;
	
	public String getBusinessName() {
		scrollToEndAction();
		return businessName.getText();
	}
	
	public String getEmployeeName() {
		return employeeName.getText();
	}
	
	public void notificationBell() {
		notificationBell.click();
		notificationback.click();
	}
	
	public DashboardPage gotoDashboard() {
		dashboard.click();
		 return new DashboardPage(driver);
	}
}
