package com.test.spruceEats.tests;

import com.test.spruceEats.pages.SpruceEatsHomePage;
import com.test.spruceEats.pages.SpruceFishAndSeafoodPage;
import com.test.spruceEats.pages.SpruceRecipePage;
import org.testng.annotations.Test;

public class SpruceRecipeTest extends SpruceEatsTestBase{

    @Test
    public void RecipeValidation() throws InterruptedException {
        SpruceEatsHomePage spruceEatsHomePage = new SpruceEatsHomePage(driver);
        spruceEatsHomePage.IngridientsFunctionality(driver);
        SpruceFishAndSeafoodPage spruceFishAndSeafoodPage=new SpruceFishAndSeafoodPage(driver);
        spruceFishAndSeafoodPage.FishAndSeafoodFunctionality(driver,"Fish for dinner");
        SpruceRecipePage spruceRecipePage = new SpruceRecipePage(driver);
        spruceRecipePage.RatingButtonClick(driver);
        spruceRecipePage.RoastedSalmonFunctionality("6-Ingredient Roasted Salmon Fillets");

    }
}
