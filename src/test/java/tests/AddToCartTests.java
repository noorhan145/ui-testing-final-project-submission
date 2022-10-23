package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NavigationBarPage;
import pages.ProductsPage;
import pages.SearchedProductsPage;
import pages.ViewCartPage;

public class AddToCartTests extends BaseTests{
    NavigationBarPage navigationBarPage;
    ProductsPage productsPage;
    SearchedProductsPage searchedProductsPage;

    @BeforeMethod
    public void clickProducts(){
        navigationBarPage = new NavigationBarPage(driver);
        productsPage = navigationBarPage.clickProductsFromNavBar();
    }

    @Test
    public void addOneProTest() {
        String productName0 = productsPage.getProductName(0);
        productsPage.addToCart(0);
        productsPage.clickViewCart();
        ViewCartPage viewCartPage = new ViewCartPage(driver);
        Assert.assertEquals(productName0, viewCartPage.getProductName(0),
                "product name should be "+productName0);
        Assert.assertEquals(viewCartPage.getProductQuantity(0), "1",
                "product quantity should be 1");

    }
    @Test
    public void addMultiProMultiTimes() {
        String productName0 = productsPage.getProductName(0);
        String productName1 = productsPage.getProductName(1);
        productsPage.addToCart(0);
        productsPage.clickContinueShopping();
        productsPage.addToCart(0);
        productsPage.clickContinueShopping();
        productsPage.addToCart(1);
        productsPage.clickContinueShopping();
        productsPage.addToCart(1);
        productsPage.clickViewCart();
        ViewCartPage viewCartPage = new ViewCartPage(driver);
        Assert.assertEquals(productName0, viewCartPage.getProductName(0),
                "product name should be "+productName0);
        Assert.assertEquals(productName1, viewCartPage.getProductName(1),
                "product name should be "+productName1);
        Assert.assertEquals(viewCartPage.getProductQuantity(0), "2",
                "product quantity should be 2");
        Assert.assertEquals(viewCartPage.getProductQuantity(1), "2",
                "product quantity should be 2");
    }
    @Test
    public void removeProductTest() {
        String productName0 = productsPage.getProductName(0);
        productsPage.addToCart(0);
        productsPage.clickViewCart();
        ViewCartPage viewCartPage = new ViewCartPage(driver);
        Assert.assertEquals(productName0, viewCartPage.getProductName(0),
                "product name should be "+productName0);
        viewCartPage.removeProduct();
        Assert.assertEquals(viewCartPage.getEmptyCartMsg(),"Cart is empty!",
                "Cart is empty! should be shown");


    }
}
