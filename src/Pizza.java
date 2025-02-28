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
    private String orderID;
    private double orderTotal;

    private static final String DEF_ORDER_ID = "DEF-SOH-099";
    private static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private static final double DEF_ORDER_TOTAL = 15.00;

    public SliceoHeaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = new ArrayList<>();
        this.pizzaIngredients.add(DEF_PIZZA_INGREDIENTS);
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

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
        this.orderID = DEF_ORDER_ID;
        this.orderTotal = 0;
    }

    public SliceoHeaven(String orderID, List<String> pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
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

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void takeOrder(int pizzaQuantity, List<String> selectedSides, List<String> selectedDrinks) {
        this.orderID = "SOH-" + (Integer.parseInt(this.orderID.split("-")[2]) + 1);
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
        printReceipt();
    }

    public void makePizza() {
        System.out.println("Making a pizza with the following ingredients: ");
        for (String ingredient : pizzaIngredients) {
            System.out.println("- " + ingredient);
        }
        System.out.println("Pizza is ready!");
    }

    private void printReceipt() {
        System.out.println("----- Receipt -----");
        System.out.println("Store Name: " + storeName);
        System.out.println("Store Address: " + storeAddress);
        System.out.println("Order ID: " + orderID);
        System.out.println("Order Total: $" + orderTotal);
        System.out.println("-------------------");
    }
    public void processCardPayment(String cardNumber, String expiryDate, int cvv) {
        int cardLength = cardNumber.length();
        if (cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
        }

        int firstCardDigit = Integer.parseInt(cardNumber.substring(0, 1));

        String blacklistedNumber = "12345678901234";
        if (cardNumber.equals(blacklistedNumber)) {
            System.out.println("Card is blacklisted. Please use another card");
        }

        int lastFourDigits = Integer.parseInt(cardNumber.substring(cardNumber.length() - 4));

        StringBuilder cardNumberToDisplay = new StringBuilder();
        cardNumberToDisplay.append(cardNumber.charAt(0));
        for (int i = 1; i < cardNumber.length() - 4; i++) {
            cardNumberToDisplay.append('*');
        }
        cardNumberToDisplay.append(cardNumber.substring(cardNumber.length() - 4));

        System.out.println("First card digit: " + firstCardDigit);
        System.out.println("Last four digits: " + lastFourDigits);
        System.out.println("Card number to display: " + cardNumberToDisplay);
    }
    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        StringBuilder specialInfo = new StringBuilder();
        specialInfo.append("Today's special: ");
        specialInfo.append(pizzaOfTheDay);
        specialInfo.append(" with ");
        specialInfo.append(sideOfTheDay);
        specialInfo.append(" for only $");
        specialInfo.append(specialPrice);
        System.out.println(specialInfo.toString());
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
        pizzeria.processCardPayment("12345678901234", "12/25", 123);
        pizzeria.specialOfTheDay("Margherita Pizza", "Fries", "12.99");
    }
}