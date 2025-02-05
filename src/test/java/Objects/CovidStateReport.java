package Objects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CovidStateReport {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CovidStateReport(WebDriver driver){
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		// Initializing PageFactory elements
        PageFactory.initElements(driver, this);
	}
	
	
	//private By states= By.className("data-filter-input");
	//private By cases = By.cssSelector("div[class='display-data'] p");
	
	@FindBy(className = "data-filter-input")
    private WebElement states;

    @FindBy(css = "div[class='display-data'] p")
    private List<WebElement> cases;
	
	
	
	public void selectState() {
		
		Select sel = new Select(states);
		sel.selectByVisibleText("Kerala");
		
	}
	
	public void getCaseData() {
		wait.until(ExpectedConditions.visibilityOfAllElements(cases));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,800)", "");
		List<WebElement> elements = (cases);
		// Create an array based on the size of the list
        //String[] textArray = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) { {
			String text = elements.get(i).getText();
            String[] parts = text.split(":"); // Split at colon
            
            if (parts.length == 2) {
                String category = parts[0].trim(); // "Total Cases"
                String value = parts[1].trim(); // "397218"
               // textArray[i] = elements.get(i).getText();
                

                // Convert value to k format
                double numValue = Double.parseDouble(value);
                
                if (numValue <= 9999) {
                	System.out.println(category + ", " + value);
                }
                else {
                	String formattedValue = String.format("%.3fk", numValue / 1000); // 397.218k
                    System.out.println(category + ", " + formattedValue);
                }
            }
		}
	}
	}

//	
//	public void PiechartValidation(\) {
//	    String[] textArray = ;
//
//	 // Initialize the variables
//	    int total = 0;
//	    int recovered = 0;
//	    int active = 0;
//	    int deathsCount = 0;
//	}
}
//}