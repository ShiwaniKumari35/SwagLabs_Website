import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CheckoutPage {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        //logging the website with the valid username and password
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //Handling the alert
        Alert alert = driver.switchTo().alert();

        // Accept the alert
        alert.accept();

        // Adding items into the cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        Thread.sleep(2000);

        // Clicking on the Checkout bag
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(5000);

        //Adding Address
        driver.findElement(By.id("first-name")).sendKeys("Shiwani");
        driver.findElement(By.id("last-name")).sendKeys("Mathuri");
        driver.findElement(By.id("postal-code")).sendKeys("811308");
        Thread.sleep(2000);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);

        WebElement slider = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(slider, 0, 500).perform(); // Drag the slider 100 pixels to the right
        Thread.sleep(2000);
        // Clicking finish for final checkout
        driver.findElement(By.id("finish")).click();
        Thread.sleep(2000);

        //clicking home page for showing again all products again
        driver.findElement(By.id("back-to-products")).click();
        driver.close();
    }
}
