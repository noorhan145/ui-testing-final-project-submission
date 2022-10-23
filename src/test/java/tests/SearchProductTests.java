package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NavigationBarPage;
import pages.ProductsPage;
import pages.SearchedProductsPage;

public class SearchProductTests extends BaseTests {
    NavigationBarPage navigationBarPage;
    ProductsPage productsPage;
    SearchedProductsPage searchedProductsPage;
    String searchPro = "dress";

    @BeforeMethod
    public void searchProduct(){
        navigationBarPage = new NavigationBarPage(driver);
        productsPage = navigationBarPage.clickProductsFromNavBar();
        searchedProductsPage = productsPage.searchProduct(searchPro);
    }

    @Test
    public void searchButtonTest()
    {

        Assert.assertTrue(searchedProductsPage.getProductTitle().toLowerCase().contains(searchPro),
              "the product don't match your searched product");

    }
    @Test
    public void searchKeywordInAllSearchResultsTest()
    {
        searchedProductsPage.putAllProductsTitleInList();
        for (int i=0 ; i <= searchedProductsPage.getProductsSize() ; i++){
            Assert.assertTrue(searchedProductsPage.getAllProductsTitle(i).toLowerCase().contains((searchPro)
            ), "the product number "+ (i+1) +" is not contain the search keyword");
        }


    }
}
