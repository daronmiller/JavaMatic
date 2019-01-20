import java.util.HashMap;

class Drink {
    private String name;
    private HashMap<Ingredient, Integer> ingredients = new HashMap<>();

    Drink(String name) {
        this.name = name;
    }

    void addIngredient(Ingredient ingredient, int quantity){
        ingredients.put(ingredient, quantity);
    }

    String getName(){
        return name;
    }

    HashMap<Ingredient, Integer> getIngredients(){
        return ingredients;
    }

    double getPrice(){
        double price = 0.0;
        for(Ingredient ingredient : ingredients.keySet()){
            price += ingredient.getCost() * ingredients.get(ingredient);
        }
        return price;
    }
}
