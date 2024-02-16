package makemytrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class selenium {
    public static void  main(String[] args){

        System.setProperty("webdriver.edge.driver","C:\\Users\\mukul\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.makemytrip.com/railways");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Wait till the page is loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Offers_Listing\"]/div[2]/div/div/div/div[4]/div[1]/div/div")));

        // Printing the URL and Title
        String currenturl = driver.getCurrentUrl();
        System.out.println("Current URL : " + currenturl);
        System.out.println("Title : " + driver.getTitle());

        //Selecting the FORM Location
        By fromLocator = By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div[1]/label");
        WebElement fromElement = driver.findElement(fromLocator);
        fromElement.click();

        // Selecting the FORM space and Entering "Delhi"
        By fromCityLocator = By.xpath("//input[@placeholder='From']");
        WebElement fromCityInput = driver.findElement(fromCityLocator);
        fromCityInput.sendKeys("Delhi");


        //Selecting the keyword from drop down menu
        By option1 = By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div");
        WebElement choose1 = wait.until(ExpectedConditions.elementToBeClickable(option1));
        choose1.click();

        //Selecting the TO Location
        By toLocator = By.xpath("//span[normalize-space()='To']");
        WebElement toElement = driver.findElement(toLocator);
        toElement.click();

        //Selecting the TO Space and Entering "Lucknow"
        By toCityLocator = By.xpath("//input[@placeholder='To']");
        WebElement toCityInput = driver.findElement(toCityLocator);
        toCityInput.sendKeys("Lucknow");

        //Selecting the keyword from drop down menu
        By option2 = By.xpath("//span[normalize-space()='Lucknow - All Stations']");
        WebElement choose2 = wait.until(ExpectedConditions.elementToBeClickable(option2));
        choose2.click();

        // Wait for the date field to be clickable and click it
        By dateFieldLocator = By.xpath("//span[@class='font32 latoBlack']");
        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(dateFieldLocator));
        dateField.click();

        // Define the next button
        By next = By.xpath("//span[@aria-label='Next Month']");

        // Define the desired month (replace with the actual value)
        String desiredMonth = "May 2024";

        // Keep clicking the next button until the desired month is displayed
        while (true) {
            // Check the current displayed month (replace with the actual locator)
            By monthLocator = By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[1]");
            String displayedMonth = driver.findElement(monthLocator).getText();

            if (displayedMonth.equals(desiredMonth)) {
                break;
            }

            // Click the next button
            WebElement nextButton = driver.findElement(next);
            nextButton.click();
        }

        // Wait for the desired date to be clickable and click it
        By dateLocator = By.xpath("//div[@aria-label='Mon May 20 2024']");
        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(dateLocator));
        date.click();

        // Wait for the class field to be clickable and click it
        By classType = By.xpath("//span[@class='appendBottom5 downArrow']");
        WebElement classField = wait.until(ExpectedConditions.elementToBeClickable(classType));
        classField.click();

        // Wait for the drop-down menu be clickable and click the required keyword.
        By option3 = By.xpath("//li[normalize-space()='Third AC']");
        WebElement choose3 = wait.until(ExpectedConditions.elementToBeClickable(option3));
        choose3.click();

        By search = By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/p/a");
        WebElement search1 = wait.until(ExpectedConditions.elementToBeClickable(search));
        search1.click();

        try {
            // Wait for 5 seconds
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Quit the driver
        driver.quit();
    }
}
