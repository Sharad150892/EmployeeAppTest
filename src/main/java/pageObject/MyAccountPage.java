package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidAction;

public class MyAccountPage extends AndroidAction{
	AndroidDriver driver;
	public MyAccountPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Profile']")
	private WebElement profile;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/tvName")
	private WebElement empName;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/tvEmail")
	private WebElement empEmail;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/tv_number")
	private WebElement empNumber;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/tvServiceName")
	private List<WebElement> serviceName;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/tvprice")
	private List<WebElement> servicePrice;
	
	@AndroidFindBy(id="com.hubwalletEmployee:id/tvServiceName")
	private List<WebElement> swipeEle;
	
	
	public void verifyEmpProfile() {
		profile.click();
	}
	
	public String verifyEmployeeName() {
		return empName.getText();
	}
	
	public String verifyEmployeeEmail() {
		return empEmail.getText();
	}
	
	public String verifyEmployeeNumber() {
		return empNumber.getText();
	}
	
	public String verifyService() {
		int count = serviceName.size();
		String services = "";
		for(int i = 0; i < count; i++) {
			services = serviceName.get(i).getText();
		}
		return services;			
	}
	
	public void swipeServiceAction() {
		int count = serviceName.size();
		for(int i = 0; i < count; i++) {
			flingeGesture(swipeEle.get(i));
		}
		
	}
	
}
