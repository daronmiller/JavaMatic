import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Inventory {
    private HashMap<Ingredient, Integer> allIngredients = new HashMap<>();
    private HashMap<Integer, Drink> allDrinks = new HashMap<>();

    private Ingredient coffeeIngredient = new Ingredient("Coffee", 0.75);
    private Ingredient decafCoffeeIngredient = new Ingredient("Decaf Coffee", 0.75);
    private Ingredient sugarIngredient = new Ingredient("Sugar", 0.25);
    private Ingredient creamIngredient = new Ingredient("Cream", 0.25);
    private Ingredient steamedMilkIngredient = new Ingredient("Steamed Milk", 0.35);
    private Ingredient foamedMilkIngredient = new Ingredient("Foamed Milk", 0.35);
    private Ingredient espressoIngredient = new Ingredient("Espresso", 1.10);
    private Ingredient cocoaIngredient = new Ingredient("Cocoa", 0.75);
    private Ingredient whippedCreamIngredient = new Ingredient("Whipped Cream", 0.75);

    Inventory() {
        fullyStockIngredients();
        initializeDrinks();
        printInventory();
    }

    void fullyStockIngredients(){
        allIngredients.put(coffeeIngredient, 10);
        allIngredients.put(decafCoffeeIngredient, 10);
        allIngredients.put(sugarIngredient, 10);
        allIngredients.put(creamIngredient, 10);
        allIngredients.put(steamedMilkIngredient, 10);
        allIngredients.put(foamedMilkIngredient, 10);
        allIngredients.put(espressoIngredient, 10);
        allIngredients.put(cocoaIngredient, 10);
        allIngredients.put(whippedCreamIngredient, 10);
    }

    private void initializeDrinks(){
        Drink coffeeDrink = new Drink("Coffee");
        coffeeDrink.addIngredient(coffeeIngredient,3);
        coffeeDrink.addIngredient(sugarIngredient,1);
        coffeeDrink.addIngredient(creamIngredient,1);

        Drink decafCoffeeDrink = new Drink("Decaf Coffee");
        decafCoffeeDrink.addIngredient(decafCoffeeIngredient,3);
        decafCoffeeDrink.addIngredient(sugarIngredient,1);
        decafCoffeeDrink.addIngredient(creamIngredient,1);

        Drink caffeLatteDrink = new Drink("Caffe Latte");
        caffeLatteDrink.addIngredient(espressoIngredient,2);
        caffeLatteDrink.addIngredient(steamedMilkIngredient,1);

        Drink caffeAmericanoDrink = new Drink("Caffe Americano");
        caffeAmericanoDrink.addIngredient(espressoIngredient,3);

        Drink caffeMochaDrink = new Drink("Caffe Mocha");
        caffeMochaDrink.addIngredient(espressoIngredient,1);
        caffeMochaDrink.addIngredient(cocoaIngredient,1);
        caffeMochaDrink.addIngredient(steamedMilkIngredient,1);
        caffeMochaDrink.addIngredient(whippedCreamIngredient,1);

        Drink cappuccinoDrink = new Drink("Cappuccino");
        cappuccinoDrink.addIngredient(espressoIngredient,2);
        cappuccinoDrink.addIngredient(steamedMilkIngredient,1);
        cappuccinoDrink.addIngredient(foamedMilkIngredient,1);

        allDrinks.put(1, caffeAmericanoDrink);
        allDrinks.put(2, caffeLatteDrink);
        allDrinks.put(3, caffeMochaDrink);
        allDrinks.put(4, cappuccinoDrink);
        allDrinks.put(5, coffeeDrink);
        allDrinks.put(6, decafCoffeeDrink);
    }

    void printInventory(){
        printIngredientInventory();
        System.out.println();
        printDrinkInventory();
        System.out.println();
    }

    private void printIngredientInventory(){
        System.out.println("Inventory:");
        ArrayList<String> ingredientNames = new ArrayList<>();
        for(Ingredient ingredient : allIngredients.keySet()){
            ingredientNames.add(ingredient.getName() + "," + allIngredients.get(ingredient));
        }
        Collections.sort(ingredientNames);
        for(String ingredientQuantity : ingredientNames){
            System.out.println(ingredientQuantity);
        }
    }

    private void printDrinkInventory(){
        System.out.println("Menu:");
        for(int i = 1; i <= allDrinks.size(); i++){
            Drink drink = allDrinks.get(i);
            System.out.println(i + "," + drink.getName() + ",$" + String.format("%.2f", drink.getPrice()) + "," + drinkIsAvailable(drink));
        }
    }

    boolean drinkIsAvailable(Drink drink){
        for(Ingredient ingredient : drink.getIngredients().keySet()){
            if(allIngredients.get(ingredient) < drink.getIngredients().get(ingredient)){
                return false;
            }
        }
        return true;
    }

    int getNumberOfDrinks(){
        return allDrinks.size();
    }

    HashMap<Integer, Drink> getAllDrinks(){
        return allDrinks;
    }

    void dispenseDrink(int selection){
        Drink drink = allDrinks.get(selection);
        if(drinkIsAvailable(drink)){
            System.out.println("Dispensing: " + drink.getName());
            for(Ingredient ingredient : drink.getIngredients().keySet()){
                int currentQuantity = allIngredients.get(ingredient);
                int quantityUsed = drink.getIngredients().get(ingredient);
                allIngredients.put(ingredient, currentQuantity - quantityUsed);
            }
        }else{
            System.out.println("Out of stock: " + drink.getName());
        }
    }
}
