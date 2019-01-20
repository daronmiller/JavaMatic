class Ingredient {
    private String name;
    private double cost;

    Ingredient(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    double getCost() {
        return cost;
    }

    String getName(){
        return name;
    }
}
