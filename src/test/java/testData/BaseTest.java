package testData;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pageObject.DashboardPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class BaseTest {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public DashboardPage dashboardPage;
	public MyAccountPage myAccountPage;
	
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws MalformedURLException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("samsung SM-A146B");
		options.setChromedriverExecutable("C:\\Users\\Admin\\Documents\\chromedriver-win64\\chromedriver.exe");
//		options.setApp("C:\\Users\\Admin\\eclipse-workspace\\AppiumProject\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setApp("C:\\Users\\Admin\\eclipse-workspace\\EmployeeAppTest\\src\\test\\java\\resources\\EA.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		dashboardPage = new DashboardPage(driver);
		myAccountPage = new MyAccountPage(driver);
	}
	
	
	
	
	@AfterClass(alwaysRun=true)
	public void TearDown() {
		driver.quit();
		service.stop();
	}
}
