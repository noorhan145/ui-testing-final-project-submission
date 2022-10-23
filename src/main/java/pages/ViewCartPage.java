package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewCartPage extends BasePage{

    private List<WebElement> productName = driver.findElements(By.xpath("//td[@class=\"cart_description\"]//a"));
    private List<WebElement> productPrice = driver.findElements(By.xpath("//td[@class=\"cart_price\"]//p"));
    private List<WebElement> totalPrice = driver.findElements(By.cssSelector(".cart_total_price"));
    private List<WebElement> productQuantity = driver.findElements(By.xpath("//td[@class=\"cart_quantity\"]//button"));
    private By removeSign = By.className("cart_quantity_delete");
    private By emptyCartMsg = By.xpath("//span[@id=\"empty_cart\"]//b");
    public ViewCartPage(WebDriver driver) {
        super(driver);
    }
    public String getProductName (int proIndex)
    {
        return productName.get(proIndex).getText();
    }

    public String getProductPrice (int proIndex)
    {
        return productPrice.get(proIndex).getText();
    }

    public String getProductQuantity (int proIndex)
    {
        return productQuantity.get(proIndex).getText();
    }

    public String getTotalPrice (int proIndex)
    {
        return totalPrice.get(proIndex).getText();
    }

    public void removeProduct() {
        clickElement(removeSign);
    }
    public String getEmptyCartMsg(){
        return getTextOfElement(emptyCartMsg);
    }




}
