package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	 protected WebDriver driver;
	  protected static final String BASE_URL = "https://inerg-test.web.app/";

	    @Parameters("browser")
	    @BeforeMethod
	    public void setUp(@Optional("chrome") String browser) { // uses chrome as default browser
	        if (driver == null) {
	            if (browser.equalsIgnoreCase("chrome")) {
	                // Setup ChromeDriver
	                WebDriverManager.chromedriver().setup();
	                driver = new ChromeDriver();

	            } else if (browser.equalsIgnoreCase("firefox")) {
	                WebDriverManager.firefoxdriver().setup();
	                driver = new FirefoxDriver();
	            } else if (browser.equalsIgnoreCase("edge")) {
	                WebDriverManager.edgedriver().setup();
	                driver = new EdgeDriver();
	                
	            }
	            else {
	                throw new IllegalArgumentException("Browser not supported: " + browser);
	            }
	           driver.manage().window().maximize();
	        }
	    }
	   
	    public void launchWebsite() {
	        driver.get(BASE_URL); // Launch the website
	    }

}