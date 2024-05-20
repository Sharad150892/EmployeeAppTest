package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidAction;

public class DashboardPage extends AndroidAction{
	
	AndroidDriver driver;
	public DashboardPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Appointments:']")
	private WebElement swipeEle;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/tvServiceRevenue")
	private WebElement serviceRevenue;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/tvNoOfAppts")
	private WebElement noOfAppts;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/tvNoOfCompleted")
	private WebElement completedAppts;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/tvNoOfCancellation")
	private WebElement cancelledAppts;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/tvNoOfShows")
	private WebElement noShowAppts;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/iv_account")
	private WebElement myAccount;
	
	public void swipe() {
		flingeGesture(swipeEle);
	}
	
	public String getServiceRevenue() {	
		return serviceRevenue.getText();
	}
	
	public String getNoOfAppointment() {	
		return noOfAppts.getText();
	}
	
	public String getCompletedAppointment() {	
		return completedAppts.getText();
	}
	
	public String getCancelledAppointment() {	
		return cancelledAppts.getText();
	}
	
	public String getNoShowAppointment() {	
		return noShowAppts.getText();
	}
	
	public MyAccountPage clickMyAccount() {
		myAccount.click();
		return new MyAccountPage(driver);
	}
}
