class InputHandler {
    private Inventory javaMatic = new Inventory();

    InputHandler(){

    }

    void handleInput(String input){
        if(input.length() > 1){
            System.out.println();
            System.out.println("Invalid selection: " + input);
            System.out.println();
            javaMatic.printInventory();
        }
        else if(isDrinkOrder(input)){
            System.out.println();
            javaMatic.dispenseDrink(Integer.parseInt(input));
            System.out.println();
            javaMatic.printInventory();
        }
        else if(input.equalsIgnoreCase("r")){
            System.out.println();
            javaMatic.fullyStockIngredients();
            System.out.println();
            javaMatic.printInventory();
        }
        else if(input.equals("")){

        }else{
            System.out.println();
            System.out.println("Invalid selection: " + input);
            System.out.println();
            javaMatic.printInventory();
        }
    }

    boolean isDrinkOrder(String input){
        int numberOfDrinks = javaMatic.getNumberOfDrinks();
        for(int i = 1; i <= numberOfDrinks; i++){
            if(Integer.toString(i).equals(input)){
                return true;
            }
        }
        return false;
    }
}
