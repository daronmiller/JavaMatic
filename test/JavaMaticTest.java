import org.junit.Assert;
import org.junit.Test;


public class JavaMaticTest {

    @Test
    public void testGetPrice() {
        Ingredient ingredient1 = new Ingredient("Coffee", 1.35);
        Ingredient ingredient2 = new Ingredient("Sugar", 1.50);
        Ingredient ingredient3 = new Ingredient("Cream", 1.00);

        Drink drink = new Drink("Coffee");
        drink.addIngredient(ingredient1, 1);
        drink.addIngredient(ingredient2, 2);
        drink.addIngredient(ingredient3, 3);

        double price = drink.getPrice();

        Assert.assertEquals(7.35, price, 0);
    }

    @Test
    public void testDrinkAvailability() {
        Inventory javaMatic = new Inventory();
        javaMatic.dispenseDrink(1);
        javaMatic.dispenseDrink(1);
        Drink drink = javaMatic.getAllDrinks().get(1);
        Assert.assertTrue(javaMatic.drinkIsAvailable(drink));
    }

    @Test
    public void testDrinkUnavailability() {
        Inventory javaMatic = new Inventory();
        javaMatic.dispenseDrink(1);
        javaMatic.dispenseDrink(1);
        javaMatic.dispenseDrink(1);
        Drink drink = javaMatic.getAllDrinks().get(1);
        Assert.assertFalse(javaMatic.drinkIsAvailable(drink));
    }

    @Test
    public void testIsDrinkOrder() {
        InputHandler inputHandler = new InputHandler();
        Assert.assertTrue(inputHandler.isDrinkOrder("1"));
    }

    @Test
    public void testIsNotDrinkOrder() {
        InputHandler inputHandler = new InputHandler();
        Assert.assertFalse(inputHandler.isDrinkOrder("e"));
    }

    @Test
    public void testRestockInventory() {
        Inventory javaMatic = new Inventory();
        javaMatic.dispenseDrink(1);
        javaMatic.dispenseDrink(1);
        javaMatic.dispenseDrink(1);
        javaMatic.fullyStockIngredients();
        Drink drink = javaMatic.getAllDrinks().get(1);
        Assert.assertTrue(javaMatic.drinkIsAvailable(drink));
    }
}