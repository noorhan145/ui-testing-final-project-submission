package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchedProductsPage extends BasePage{

   private By productTitle = By.cssSelector("div[class=\"productinfo text-center\"]>p");
   private List<WebElement> allProductsTitle = driver.findElements(By.cssSelector("div[class=\"productinfo text-center\"]>p"));
   private List<String> listOfProductsTitle = new ArrayList<String>();
    public SearchedProductsPage(WebDriver driver) {
        super(driver);
    }
    public String getProductTitle ()
    {
        return getTextOfElement(productTitle);
    }
    public void putAllProductsTitleInList ()
    {
        for(WebElement ele: allProductsTitle){
             listOfProductsTitle.add(ele.getText());
        }
    }
    public String getAllProductsTitle (int i)
    {
        return listOfProductsTitle.get(i);
    }
    public int getProductsSize(){
        return listOfProductsTitle.size();
    }
    }
    /*
    for (int i=0; i<= allProductsTitle.size() ; i++){
            return (allProductsTitle.get(i));}
     */



