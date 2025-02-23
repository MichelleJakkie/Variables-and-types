import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class SliceoHeaven {
    private String storeName;
    private String storeAddress;
    private String storeEmail;
    private String storePhone;
    private String storeMenu;
    private List<String> pizzaIngredients;
    private double pizzaPrice;
    private List<String> sides;
    private List<String> drinks;
    private Map<String, Double> sidePrices;
    private Map<String, Double> drinkPrices;
    private int orderID;
    private double orderTotal;
    public SliceoHeaven(String name, String address, String email, String phone, String menu, List<String> ingredients, double price,
                        List<String> sideItems, Map<String, Double> sideItemPrices, List<String> drinkItems, Map<String, Double> drinkItemPrices) {
        this.storeName = name;
        this.storeAddress = address;
        this.storeEmail = email;
        this.storePhone = phone;
        this.storeMenu = menu;
        this.pizzaIngredients = ingredients;
        this.pizzaPrice = price;
        this.sides = sideItems;
        this.sidePrices = sideItemPrices;
        this.drinks = drinkItems;
        this.drinkPrices = drinkItemPrices;
        this.orderID = 0;
        this.orderTotal = 0;
    }
    public String getStoreName() {
        return storeName;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getStoreAddress() {
        return storeAddress;
    }
    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }
    public String getStoreEmail() {
        return storeEmail;
    }
    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }
    public String getStorePhone() {
        return storePhone;
    }
    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }
    public String getStoreMenu() {
        return storeMenu;
    }
    public void setStoreMenu(String storeMenu) {
        this.storeMenu = storeMenu;
    }
    public List<String> getPizzaIngredients() {
        return pizzaIngredients;
    }
    public void setPizzaIngredients(List<String> pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }
    public double getPizzaPrice() {
        return pizzaPrice;
    }
    public void setPizzaPrice(double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }
    public List<String> getSides() {
        return sides;
    }
    public void setSides(List<String> sides) {
        this.sides = sides;
    }
    public List<String> getDrinks() {
        return drinks;
    }
    public void setDrinks(List<String> drinks) {
        this.drinks = drinks;
    }
    public int getOrderID() {
        return orderID;
    }
    public double getOrderTotal() {
        return orderTotal;
    }
    public void takeOrder(int pizzaQuantity, List<String> selectedSides, List<String> selectedDrinks) {
        orderID++;
        orderTotal = pizzaQuantity * pizzaPrice;

        for (String side : selectedSides) {
            if (sidePrices.containsKey(side)) {
                orderTotal += sidePrices.get(side);
            } else {
                System.out.println("Warning: " + side + " is not in the side menu.");
            }
        }

        for (String drink : selectedDrinks) {
            if (drinkPrices.containsKey(drink)) {
                orderTotal += drinkPrices.get(drink);
            } else {
                System.out.println("Warning: " + drink + " is not in the drink menu.");
            }
        }

        System.out.println("Order ID: " + orderID + " has been placed.");
    }
    public void makePizza() {
        System.out.println("Making a pizza with the following ingredients: ");
        for (String ingredient : pizzaIngredients) {
            System.out.println("- " + ingredient);
        }
        System.out.println("Pizza is ready!");
    }
    public void printReceipt() {
        System.out.println("----- Receipt -----");
        System.out.println("Store Name: " + storeName);
        System.out.println("Store Address: " + storeAddress);
        System.out.println("Order ID: " + orderID);
        System.out.println("Order Total: $" + orderTotal);
        System.out.println("-------------------");
    }
}
public class Pizza {
    public static void main(String[] args) {
        List<String> pizzaIngredients = new ArrayList<>();
        pizzaIngredients.add("Tomato Sauce");
        pizzaIngredients.add("Cheese");
        pizzaIngredients.add("Pepperoni");
        List<String> sides = new ArrayList<>();
        sides.add("Garlic Bread");
        sides.add("Onion Rings");
        Map<String, Double> sidePrices = new HashMap<>();
        sidePrices.put("Garlic Bread", 3.0);
        sidePrices.put("Onion Rings", 3.5);
        List<String> drinks = new ArrayList<>();
        drinks.add("Coke");
        drinks.add("Sprite");
        Map<String, Double> drinkPrices = new HashMap<>();
        drinkPrices.put("Coke", 2.0);
        drinkPrices.put("Sprite", 2.0);
        SliceoHeaven pizzeria = new SliceoHeaven("Slice - o - Heaven", "123 Pizza St", "info@sliceoheaven.com", "555 - 1234",
                "Pizza, Sides, Drinks", pizzaIngredients, 10.0, sides, sidePrices, drinks, drinkPrices);

        List<String> selectedSides = new ArrayList<>();
        selectedSides.add("Garlic Bread");
        List<String> selectedDrinks = new ArrayList<>();
        selectedDrinks.add("Coke");
        pizzeria.takeOrder(1, selectedSides, selectedDrinks);
        pizzeria.makePizza();
        pizzeria.printReceipt();
    }
}
